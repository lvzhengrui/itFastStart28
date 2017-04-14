

Spark入门实战系列--9.Spark图计算GraphX介绍及实例
http://www.cnblogs.com/shishanyuan/p/4747793.html

pregel 与 spark graphX 的 pregel api
http://blog.csdn.net/u013468917/article/details/51199808

GraphX中Pregel单源点最短路径
http://blog.csdn.net/li385805776/article/details/20487219

Google后Hadoop时代的新“三驾马车”——Caffeine、Pregel、Dremel
http://www.csdn.net/article/2012-08-20/2808870


---------------------------------------
Pregel模式
GraphX的核心代码只有3千多行，而在此之上实现的Pregel模式，只要短短的20多行

图数据库
Neo4j、Titan

目前基于图的并行计算框架已经有很多，比如来自Google的Pregel、来自Apache开源的图计算框架Giraph/HAMA以及最为著名的GraphLab，
其中Pregel、HAMA和Giraph都是非常类似的，都是基于BSP（Bulk Synchronous Parallell）模式。




