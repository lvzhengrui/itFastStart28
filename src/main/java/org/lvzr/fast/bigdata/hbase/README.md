源自Google的Bigtable论文，发表于2006年11月，HBase是Google Bigtable克隆版
HBase是一个针对结构化数据的可伸缩、高可靠、高性能、分布式和面向列的动态模式数据库。
和传统关系数据库不同，HBase采用了BigTable的数据模型：增强的稀疏排序映射表（Key/Value），
其中，键由行关键字、列关键字和时间戳构成。HBase提供了对大规模数据的随机、实时读写访问，同时，
HBase中保存的数据可以使用MapReduce来处理，它将数据存储和并行计算完美地结合在一起。
数据模型：Schema-->Table-->Column Family-->Column-->RowKey-->TimeStamp-->Value

