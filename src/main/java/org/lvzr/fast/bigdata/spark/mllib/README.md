
Spark MLlib系列(一)：入门介绍
http://blog.csdn.net/shifenglov/article/details/43762705

Machine Learning Library (MLlib) Programming Guide
http://spark.apache.org/docs/1.2.0/mllib-guide.html


倾情大奉送--Spark入门实战系列
http://www.cnblogs.com/shishanyuan/p/4699644.html

Spark入门实战系列--8.Spark MLlib（上）--机器学习及SparkMLlib简介
http://www.cnblogs.com/shishanyuan/p/4747761.html



---------------------------------------
MLlib 是Spark的可以扩展的机器学习库，由以下部分组成：通用的学习算法和工具类，包括分类，回归，聚类，协同过滤，降维，当然也包括调优的部分
Data types  

Basic statistics  (基本统计)
	summary statistics 概括统计
	correlations 相关性
	stratified sampling 分层取样
	hypothesis testing 假设检验
	random data generation 随机数生成
	
Classification and regression   (分类一般针对离散型数据而言的，回归是针对连续型数据的。本质上是一样的)
	linear models (SVMs, logistic regression, linear regression) 线性模型（支持向量机，逻辑回归，线性回归）
	naive Bayes 贝叶斯算法
	decision trees  决策树
	ensembles of trees (Random Forests and Gradient-Boosted Trees) 多种树（随机森林和梯度增强树）

Collaborative filtering   协同过滤
	alternating least squares (ALS)  (交替最小二乘法(ALS) )

Clustering  聚类
	k-means k均值算法

Dimensionality reduction   (降维)
	singular value decomposition (SVD)  奇异值分解
	principal component analysis (PCA) 主成分分析

Feature extraction and transformation 特征提取和转化

Optimization (developer) 优化部分
	stochastic gradient descent 随机梯度下降
	limited-memory BFGS (L-BFGS) 短时记忆的BFGS (拟牛顿法中的一种,解决非线性问题)

MLlib当前在非常活跃的开发情况下，所以那些被标记成 Experimental/DeveloperApi 在未来的发布种可能会被修改

依赖
MLlib使用了线性代数包 Breeze, 它依赖于netlib-java和jblas。netlib-java 和 jblas 需要依赖native Fortran routines。
所以你需要安装gfortran runtime library （安装方法在这个链接中），如果你的集群的节点中没有安装native Fortran routines。
MLlib 会抛出一个link error，如果没有安装native Fortran routines。

如果你需要使用spark的python开发，你需要 NumPy version 1.4或以上版本.


当前最近版本1.2
个人认为当前1.2版本的最大的改进应该是发布了称为spark.ml的机器学习工具包，支持了pipeline的学习模式，即多个算法可以用不同参数以
流水线的形式运行。在工业界的机器学习应用部署过程中，pipeline的工作模式是很常见的。新的ML工具包使用Spark的SchemaRDD来表
示机器学习的数据集合，提供了Spark SQL直接访问的接口。此外，在机器学习的算法方面，增加了两个基于树的方法，随机森林和梯
度增强树。还有貌似性能上有优化，看过一篇DataBricks的ppt，据说1.2版本的算法在性能上比1.1版本平均快了3倍


-------------------------------------------


































