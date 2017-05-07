

##Mahout推荐算法API详解
http://blog.csdn.net/zhoubl668/article/details/13297663/



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


-----------------------------------
###Mahout内置聚类、分类以及协同过滤等算法。除此之外还有：
1. 基于矩阵分解的推荐系统
2. K-均值，模糊k-均值聚类算法
3. 隐含狄利克雷分配算法
4. 奇异值分解
5. 逻辑回归分类器
6. (互补)朴素贝叶斯分类器
7. 随机森林分类器


---------------------------------
在Mahout实现的机器学习算法：

算法类	算法名	中文名

分类算法	
Logistic Regression	逻辑回归
Bayesian	贝叶斯
SVM	支持向量机
Perceptron	感知器算法
Neural Network	神经网络
Random Forests	随机森林
Restricted Boltzmann Machines	有限波尔兹曼机

聚类算法	
Canopy Clustering	Canopy聚类
K-means Clustering	K均值算法
Fuzzy K-means	模糊K均值
Expectation Maximization	EM聚类（期望最大化聚类）
Mean Shift Clustering	均值漂移聚类
Hierarchical Clustering	层次聚类
Dirichlet Process Clustering	狄里克雷过程聚类
Latent Dirichlet Allocation	LDA聚类
Spectral Clustering	谱聚类

关联规则挖掘	
Parallel FP Growth Algorithm	并行FP Growth算法

回归	
Locally Weighted Linear Regression	局部加权线性回归

降维/维约简	
Singular Value Decomposition	奇异值分解
Principal Components Analysis	主成分分析
Independent Component Analysis	独立成分分析
Gaussian Discriminative Analysis	高斯判别分析

进化算法	并行化了Watchmaker框架	

推荐/协同过滤	
Non-distributed recommenders	Taste(UserCF, ItemCF, SlopeOne）
Distributed Recommenders	ItemCF

向量相似度计算	
RowSimilarityJob	计算列间相似度
VectorDistanceJob	计算向量间距离

非Map-Reduce算法	Hidden Markov Models	隐马尔科夫模型

集合方法扩展	Collections	扩展了java的Collections类



