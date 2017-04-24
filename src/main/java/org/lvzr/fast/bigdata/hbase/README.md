




###配置
HBASE_HOME=E:\开源项目\bigdata\hbase-1.3.1
Path=%HBASE_HOME%\bin
echo %HBASE_HOME%

###必须配置hosts
hbase.zookeeper.quorum配置为计算机名jerry2016
C:/Windows/System32/drivers/etc/hosts文件加上一句：
127.0.0.1 jerry2016



###启停命令
cd E:\开源项目\bigdata\hbase-1.3.1\bin
bin>start-hbase
bin>stop-hbase

启动hbase，自动在hadoop中创建hbase.rootdir目录
bin>hadoop fs -ls /


###前台页面
http://127.0.0.1:16010/

###常用shell命令
bin>hbase shell

查看表
bin>list

删除表
bin>disable 't1'
bin>drop 't1'

查看表结构
bin>describe 't1'

查看表数据
bin>scan 'hbase:meta'

创建表和列族
bin>create 't1','f1','f2'

增加列族
bin>alter 't1','f3','f4'

操作数据
bin>put 't1','r1','f1:c1','value0'
bin>get 't1','r1'
bin>get 't1','r1','f1'
bin>delete 't1','rowkey001','f1:col1'
bin>deleteall 't1','rowkey001'
bin>truncate 't1'
bin> count 't1', {INTERVAL => 100, CACHE => 500}















































-----------------------------------------------------------------------------------------
源自Google的Bigtable论文，发表于2006年11月，HBase是Google Bigtable克隆版
HBase是一个针对结构化数据的可伸缩、高可靠、高性能、分布式和面向列的动态模式数据库。
和传统关系数据库不同，HBase采用了BigTable的数据模型：增强的稀疏排序映射表（Key/Value），
其中，键由行关键字、列关键字和时间戳构成。HBase提供了对大规模数据的随机、实时读写访问，同时，
HBase中保存的数据可以使用MapReduce来处理，它将数据存储和并行计算完美地结合在一起。
数据模型：Schema-->Table-->Column Family-->Column-->RowKey-->TimeStamp-->Value

------------------------------------------
###深入HBase架构解析（一）
http://www.blogjava.net/DLevin/archive/2015/08/22/426877.html
 
###hbase 学习笔记一---基本概念
http://blog.csdn.net/zhouleilei/article/details/12653243


---------------------------------------------------
###Apache HBase 2015年发展回顾与未来展望
http://chuansong.me/n/2112995

在 HBase 中，Table 被横向划分为 Region，它是一段数据的管理者，Region 被分发到 RegionServer 上进行管理，
一个 Region 只被一个 RegionServer 管理，它的数据存储在 HDFS 上，是可以有多个副本的。

也就是说：管理者 (Region) 只有一个，数据有多个副本。

HBase 的以前实现Hbase0.8中，当一台 RegionServer 不可用时，需要数十秒甚至数分钟才可以完成发现和恢复工作，在这段时间内，
这台 RegionServer 上的 Region 是不可用的。当一个 Region 不可用时，它需要一段时间才可以被其他 RegionServer 接管。

在最新Hbase1.0的实现中，一个 Region 可以有多个副本（Region 是数据的管理者，是实际数据的抽象），分布在多个 RegionServer 上。

 

 
------------------------------------------
###其中HMaster节点用于：
管理HRegionServer，实现其负载均衡。
管理和分配HRegion，比如在HRegion split时分配新的HRegion；在HRegionServer退出时迁移其内的HRegion到其他HRegionServer上。
实现DDL操作（Data Definition Language，namespace和table的增删改，column familiy的增删改等）。
管理namespace和table的元数据（实际存储在HDFS上）。
权限控制（ACL）。

###HRegionServer节点用于：
存放和管理本地HRegion。
读写HDFS，管理Table中的数据。
Client直接通过HRegionServer读写数据（从HMaster中获取元数据，找到RowKey所在的HRegion/HRegionServer后）。

###ZooKeeper集群是协调系统，用于：
存放整个 HBase集群的元数据以及集群的状态信息。
实现HMaster主从节点的failover。

HBase Client通过RPC方式和HMaster、HRegionServer通信；一个HRegionServer可以存放1000个HRegion；底层Table数据存储于HDFS中，
而HRegion所处理的数据尽量和数据所在的DataNode在一起，实现数据的本地化；数据本地化并不是总能实现，比如在HRegion移动(如因Split)时，
需要等下一次Compact才能继续回到本地化。


这个架构图比较清晰的表达了HMaster和NameNode都支持多个热备份，使用ZooKeeper来做协调；ZooKeeper并不是云般神秘，
它一般由三台机器组成一个集群，内部使用PAXOS算法支持三台Server中的一台宕机，也有使用五台机器的，此时则可以支持同
时两台宕机，既少于半数的宕机，然而随着机器的增加，它的性能也会下降；RegionServer和DataNode一般会放在相同的Server上实现数据的本地化。

-------------------------------------
###HRegion
HBase使用RowKey将表水平切割成多个HRegion，***从HMaster的角度，每个HRegion都纪录了它的StartKey和EndKey***
（第一个HRegion的StartKey为空，最后一个HRegion的EndKey为空），由于RowKey是排序的，因而Client可以通过HMaster快速的定位每个RowKey在哪个HRegion中
。***HRegion由HMaster分配到相应的HRegionServer中***，然后由HRegionServer负责HRegion的启动和管理，和Client的通信，
负责数据的读(使用HDFS)。每个HRegionServer可以同时管理1000个左右的HRegion（这个数字怎么来的？没有从代码中看到限制，
难道是出于经验？超过1000个会引起性能问题？来回答这个问题：感觉这个1000的数字是从BigTable的论文中来的（5 Implementation节）：
Each tablet server manages a set of tablets(typically we have somewhere between ten to a thousand tablets per tablet server)）。


###HMaster
***HMaster没有单点故障问题，可以启动多个HMaster，通过ZooKeeper的Master Election机制保证同时只有一个HMaster出于Active状态***，
其他的HMaster则处于热备份状态。一般情况下会启动两个HMaster，非Active的HMaster会定期的和Active HMaster通信以获取其最新状态，
从而保证它是实时更新的，因而如果启动了多个HMaster反而增加了Active HMaster的负担。前文已经介绍过了HMaster的主要用于HRegion的分配和
管理，DDL(Data Definition Language，既Table的新建、删除、修改等)的实现等，既它主要有两方面的职责：
协调HRegionServer
	启动时HRegion的分配，以及负载均衡和修复时HRegion的重新分配。
	监控集群中所有HRegionServer的状态(通过Heartbeat和监听ZooKeeper中的状态)。
Admin职能
	创建、删除、修改Table的定义。


###ZooKeeper：协调者
ZooKeeper为HBase集群提供协调服务，它***管理着HMaster和HRegionServer的状态(available/alive等)，并且会在它们宕机时通知给HMaster***，
从而HMaster可以实现HMaster之间的failover，或对宕机的HRegionServer中的HRegion集合的修复(将它们分配给其他的HRegionServer)。
ZooKeeper集群本身使用一致性协议(PAXOS协议)保证每个节点状态的一致性。

--------------------------------------------
###客户端在第一次访问用户Table的流程
从ZooKeeper(/hbase/meta-region-server)中获取hbase:meta的位置（HRegionServer的位置），缓存该位置信息。
从HRegionServer中查询用户Table对应请求的RowKey所在的HRegionServer，缓存该位置信息。
从查询到HRegionServer中读取Row。

---------------------------------------------
###HRegionServer详解
HRegion是一个Table中的一个Region在一个HRegionServer中的表达。一个Table可以有一个或多个Region，他们可以在一个
相同的HRegionServer上，也可以分布在不同的HRegionServer上，一个HRegionServer可以有多个HRegion，他们分别属于
不同的Table。****HRegion由多个Store(HStore)构成，每个HStore对应了一个Table在这个HRegion中的一个Column Family****，即
每个Column Family就是一个集中的存储单元，因而最好将具有相近IO特性的Column存储在一个Column Family，以实现高效读
取(数据局部性原理，可以提高缓存的命中率)。***HStore是HBase中存储的核心，它实现了读写HDFS功能，一个HStore由一个MemStore 和0个或多个StoreFile组成***。
MemStore是一个写缓存(In Memory Sorted Buffer)，所有数据的写在完成WAL日志写后，会 写入MemStore中，由MemStore根
据一定的算法将数据Flush到地层HDFS文件中(HFile)，通常每个HRegion中的每个 Column Family有一个自己的MemStore。
HFile(StoreFile) 用于存储HBase的数据(Cell/KeyValue)。在HFile中的数据是按RowKey、Column Family、Column排序，对相
同的Cell(即这三个值都一样)，则按timestamp倒序排列。





































