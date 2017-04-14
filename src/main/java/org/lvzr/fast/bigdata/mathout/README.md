Mahout起源于2008年，最初是Apache Lucent的子项目，它在极短的时间内取得了长足的发展，现在是Apache的顶级项目。
Mahout的主要目标是创建一些可扩展的机器学习领域经典算法的实现，旨在帮助开发人员更加方便快捷地创建智能应用程序。
Mahout现在已经包含了聚类、分类、推荐引擎（协同过滤）和频繁集挖掘等广泛使用的数据挖掘方法。除了算法，Mahout还包含数据
的输入/输出工具、与其他存储系统（如数据库、MongoDB 或Cassandra）集成等数据挖掘支持架构。

Mahout学习之Mahout简介、安装、配置、入门程序测试
http://itindex.net/detail/49323-mahout-%E5%AD%A6%E4%B9%A0-mahout

Mahout学习路线图
http://blog.fens.me/hadoop-mahout-roadmap/
 
用Maven构建Mahout项目
http://blog.fens.me/hadoop-mahout-maven-eclipse/



--------------------------------
上传测试数据
hadoop fs -put synthetic_control.data /user/root/testdata

使用Mahout中的kmeans聚类算法，执行命令：
mahout -core  org.apache.mahout.clustering.syntheticcontrol.kmeans.Job



