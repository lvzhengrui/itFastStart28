源自于Google的GFS论文，发表于2003年10月，HDFS是GFS克隆版。
是Hadoop体系中数据存储管理的基础。它是一个高度容错的系统，能检测和应对硬件故障，用于在低成本的通用硬件上运行。HDFS简化了文件的一致性模型，
通过流式数据访问，提供高吞吐量应用程序数据访问功能，适合带有大型数据集的应用程序。

Client：切分文件；访问HDFS；与NameNode交互，获取文件位置信息；与DataNode交互，读取和写入数据。
NameNode：Master节点，在hadoop1.X中只有一个，管理HDFS的名称空间和数据块映射信息，配置副本策略，处理客户端请求。
DataNode：Slave节点，存储实际的数据，汇报存储信息给NameNode。
Secondary NameNode：辅助NameNode，分担其工作量；定期合并fsimage和fsedits，推送给NameNode；紧急情况下，可辅助恢复NameNode，
但Secondary NameNode并非NameNode的热备。


