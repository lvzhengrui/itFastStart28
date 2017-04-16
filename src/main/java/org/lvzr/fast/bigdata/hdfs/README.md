源自于Google的GFS论文，发表于2003年10月，HDFS是GFS克隆版。
是Hadoop体系中数据存储管理的基础。它是一个高度容错的系统，能检测和应对硬件故障，用于在低成本的通用硬件上运行。HDFS简化了文件的一致性模型，
通过流式数据访问，提供高吞吐量应用程序数据访问功能，适合带有大型数据集的应用程序。

Client：切分文件；访问HDFS；与NameNode交互，获取文件位置信息；与DataNode交互，读取和写入数据。
NameNode：Master节点，在hadoop1.X中只有一个，管理HDFS的名称空间和数据块映射信息，配置副本策略，处理客户端请求。
DataNode：Slave节点，存储实际的数据，汇报存储信息给NameNode。
Secondary NameNode：辅助NameNode，分担其工作量；定期合并fsimage和fsedits，推送给NameNode；紧急情况下，可辅助恢复NameNode，
但Secondary NameNode并非NameNode的热备。


----------------------------------
hadoop配置文件详解、安装及相关操作
http://blog.csdn.net/lin_fs/article/details/7349497

hadoop三个配置文件的参数含义说明(完整版)
http://blog.csdn.net/yangjl38/article/details/7583374
web端口，RPC server端口，http Server端口区别?



---------------------------------

HDFS的数据通信机制
http://blog.csdn.net/knowledgeaaa/article/details/17264291

Hadoop NameNode元数据相关文件目录解析 – 过往记忆
https://www.iteblog.com/archives/967.html

Hadoop中NameNode存储的元数据记录和NameNode的启动过程
http://www.cnblogs.com/zhangcm/archive/2012/11/24/2787142.html

hadoop分析之一HDFS元数据解析
http://blog.csdn.net/kntao/article/details/7769199


 

--------------------------------------------
###hdfs元数据
NameNode（NN代指）中存储的HDFS中文件的元信息，从大的方面可以分为3个部分整个文件系统的目录树、文件名与blockid的映射关系、blockid所在的DN信息。
其中前两项是永久存在NN中的（image文件），第三项是DN启动时向NN汇报生成的，这样能够简化NN的存储逻辑，并且大大减小image文件的大小。
 
###hadoop的元数据fsimage和edits
http://blog.csdn.net/qa38113202/article/details/51690924

fsimage和edits文件都是经过序列化的，在NameNode启动的时候，它会将****fsimage文件中的内容加载到内存中****，之后再执行edits文件中的各项操作，
使得内存中的元数据和实际的同步，存在内存中的元数据支持客户端的读操作。

NameNode起来之后，HDFS中的更新操作会重新写到edits文件中，因为***fsimage文件一般都很大（GB级别的很常见）***，如果所有的更新操作都往fsimage文
件中添加，这样会导致系统运行的十分缓慢，但是如果往edits文件里面写就不会这样，每次执行写操作之后，且在向客户端发送成功代码之前，edits文件都
需要同步更新。如果一个文件比较大，使得写操作需要向多台机器进行操作，只有当所有的写操作都执行完成之后，写操作才会返回成功，这样的好处是任何
的操作都不会因为机器的故障而导致元数据的不同步。

fsimage包含Hadoop文件系统中的所有目录和文件idnode的序列化信息；对于文件来说，包含的信息有修改时间、访问时间、块大小和***组成一个文件块信息***等；
而对于目录来说，包含的信息主要有修改时间、访问控制权限等信息。***fsimage并不包含DataNode的信息，而是包含DataNode上块的映射信息***，并存放到内存
中，当一个新的DataNode加入到集群中，DataNode都会向NameNode提供块的信息，而NameNode会定期的“索取”块的信息，以使得NameNode拥有最新的块
映射。因为fsimage包含Hadoop文件系统中的所有目录和文件idnode的序列化信息，所以如果fsimage丢失或者损坏了，那么即使DataNode上有块的数据，
但是我们没有文件到块的映射关系，我们也无法用DataNode上的数据！***所以定期及时的备份fsimage和edits文件非常重要***！

 
在前面我们也提到，文件系统客户端执行的所以写操作首先会被记录到edits文件中，那么久而久之，edits会非常的大，
而NameNode在重启的时候需要执行edits文件中的各项操作，那么这样会导致NameNode启动的时候非常长！在下篇文章中我
会谈到在Hadoop 1.x版本和Hadoop 2.x版本是怎么处理edits文件和fsimage文件的。

###Inode
可以看出FSNamesystem对于目录结构的操作都是通过FSDirectory对象进行的。在FSDirectory中有一个表示系统目录根的rootDir，
rootDir是INodeDirectoryWithQuota类型，这就表明FSDirectory是作为Inode（类似Linux中的inode）与FSNamesystem之间的桥梁，
FSDirectory封装了Inode提供了对外查询的接口。

Inode是一个抽象类，他有两个子类INodeDirectory和INodeFile。顾名思义，INodeFile代表的是一个具体的文件，而INodeDirectory代表的是一个文件目录。
接着看一下INodeDirectory与INodeFile之间的区别。在INodeFile中最重要的一个域是
protected BlockInfo blocks[] = null;      
这就是代表每个文件所对应的blockid。而在INodeDirectory中最重要的部分是

private List<INode> children;    
这就是一个文件目录中的目录项的集合，也就是目录树。

上面我们知道了目录树和blockid的存储结构，接着来看在image文件和edits文件时候是否按照这样的结构进行组织。


------------------------------


响应客户端请求的是active节点，因此只有active节点保存了最新的元数据。元数据分为两部分，一部分是刚写入新的元数据（edits），
另一部分是合并后的较旧的（fsimage）。HA机制解决同步问题的方法是将active节点新写入的edits元数据放在zookeeper集群上
（zookeeper集群主要功能是实现少量数据的分布式同步管理），standby节点在active节点正常情况下只需要将zookeeper集群上edits文件
同步到自己的fsimage中就可以。

Hadoop框架为这个集群专门写了个分布式应用qjournal（依赖zookeeper实现），实现qjournal的节点称为journalnode。
       
       
两个NameNode为了数据同步，会通过一组称作JournalNodes的独立进程进行相互通信。当active状态的NameNode的命名空间有任何修改时，
会告知大部分的JournalNodes进程。standby状态的NameNode有能力读取JNs中的变更信息，并且一直监控edit log的变化，把变化应用于自己
的命名空间。standby可以确保在集群出错时，命名空间状态已经完全同步了

对于HA集群而言，确保同一时刻只有一个NameNode处于active状态是至关重要的。否则，两个NameNode的数据状态就会产生分歧，可能丢失数据，或
者产生错误的结果。为了保证这点，这就需要利用使用ZooKeeper了。首先HDFS集群中的两个NameNode都在ZooKeeper中注册，当active状态的
NameNode出故障时，ZooKeeper能检测到这种情况，它就会自动把standby状态的NameNode切换为active状态。










