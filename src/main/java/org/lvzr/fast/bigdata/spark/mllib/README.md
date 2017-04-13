
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
MLlib基于RDD，天生就可以与Spark SQL、GraphX、Spark Streaming无缝集成，以RDD为基石，4个子框架可联手构建大数据计算中心！

MLlib是MLBase一部分，其中MLBase分为四部分：MLlib、MLI、ML Optimizer和MLRuntime。

ML Optimizer会选择它认为最适合的已经在内部实现好了的机器学习算法和相关参数，来处理用户输入的数据，并返回模型或别的帮助分析的结果；

MLI 是一个进行特征抽取和高级ML编程抽象的算法实现的API或平台；

MLlib是Spark实现一些常见的机器学习算法和实用程序，包括分类、回归、聚类、协同过滤、降维以及底层优化，该算法可以进行可扩充； 
MLRuntime 基于Spark计算框架，将Spark的分布式计算应用到机器学习领域。



-----------------------------------------------
线性回归分析的整个过程可以简单描述为如下三个步骤：

（1）寻找合适的预测函数，即上文中的 h(x) ，用来预测输入数据的判断结果。这个过程是非常关键的，需要对数据有一定的了解或分析，知道或者猜测
预测函数的“大概”形式，比如是线性函数还是非线性函数，若是非线性的则无法用线性回归来得出高质量的结果。

（2）构造一个Loss函数（损失函数），该函数表示预测的输出（h）与训练数据标签之间的偏差，可以是二者之间的差（h-y）或者是其他的形式（如平方差开方）
。综合考虑所有训练数据的“损失”，将Loss求和或者求平均，记为 J(θ) 函数，表示所有训练数据预测值与实际类别的偏差。

（3）显然， J(θ) 函数的值越小表示预测函数越准确（即h函数越准确），所以这一步需要做的是找到 J(θ) 函数的最小值。找函数的最小值有不同的方法，
Spark中采用的是梯度下降法（stochastic gradient descent，SGD)。






































