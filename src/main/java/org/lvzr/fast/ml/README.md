

Spark入门实战系列--8.Spark MLlib（上）--机器学习及SparkMLlib简介
http://www.cnblogs.com/shishanyuan/p/4747761.html





机器学习笔记整理全解
http://m.blog.csdn.net/article/details?id=69488610&from=singlemessage&isappinstalled=1


常见的七种回归技术
http://www.jianshu.com/p/15dd20f8d02c
https://www.analyticsvidhya.com/blog/2015/08/comprehensive-guide-regression/

看完《机器学习》的总结与心得
http://www.ppvke.com/Blog/archives/34551

【原】数据分析/数据挖掘/机器学习---- 必读书目
http://www.cnblogs.com/charlotte77/p/5381681.html

斯坦福大学机器学习课程个人笔记完整版
https://wenku.baidu.com/view/99b86f70650e52ea54189862.html


大数据竞赛平台——Kaggle 入门篇
http://blog.csdn.net/u012162613/article/details/41929171

Python csv模块的使用
http://blog.csdn.net/u012162613/article/details/41915859

----------------------
首先，想解决上面的题目，还是需要一点ML算法的基础的，另外就是要会用编程语言和相应的第三方库来实现算法，常用的有：
Python以及对应的库numpy、scipy、scikit-learn（实现了ML的一些算法，可以直接用）、theano（DeepLearning的算法包）。
R语言、weka
如果用到深度学习的算法，cuda、caffe也可以用

感知器学习算法
http://blog.csdn.net/stan1989/article/details/8565499

机器学习入门资源不完全汇总
http://www.open-open.com/lib/view/open1420957787359.html

斯坦福大学Andrew Ng教授主讲的《机器学习》公开课观后感
http://blog.csdn.net/myarrow/article/details/50518020


中文版（含翻译版）
1. 李航，统计学习方法
2. Pang-Ning Tan, Michael Steinbach  ， Vipin Kumar， 数据挖掘导论
3. Peter Harrington 机器学习实践


------------------------
方差是各个数据分别与其平均数之差的平方的和的平均数
http://blog.csdn.net/Leyvi_Hsing/article/details/54022612
标准差为方差的开根号
高斯分布/正态分布=与平均数U有几个标准差Q的样本数占到全样本数的百分之九十几，概率分布状况
伯努利分布，高斯分布，泊松分布，贝塔分布，狄特里特分布都属于指数分布。

-------------------------
logistic回归
逻辑回归
sigmoid回归
欧式距离
余玄相似度
皮尔逊相关度
高斯核


子算法：
最小二乘法
梯度下降法
http://ms.csdn.net/share/FF07FCF78F722ABA7A4E7970B5E724CE_1_IPHONE_APP
高斯-牛顿法

线性回归
二次回归(二次曲线)
多元线性回归

一般来说，回归不用在分类问题上，因为回归是连续型模型，而且受噪声影响比较大。如果非要应用进入，可以使用对数回归。

迭代更新的方式有两种，一种是批梯度下降，也就是对全部的训练数据求得误差后再对θ进行更新，
另外一种是增量梯度下降，每扫描一步都要对θ进行更新。前一种方法能够不断收敛，后一种方法结果可能不断在收敛处徘徊。   
一般来说，梯度下降法收敛速度还是比较慢的。   另一种直接计算结果的方法是最小二乘法。 

最近写作业正好用到levenberg-Marquart算法。抛个砖怒答一发。首先梯度下降法和高斯牛顿法都是最优化方法。
其区别之处在于，梯度下降法在寻找目标函数极小值时，是沿着反梯度方向进行寻找的。梯度的定义就是指向标量场增长最快的方向，
在寻找极小值时，先随便定初始点（x0，y0）然后进行迭代不断寻找直到梯度的模达到预设的要求。但是梯度下降法的缺点之处在于：
在远离极小值的地方下降很快，而在靠近极小值的地方下降很慢。而高斯牛顿法是一种非线性最小二乘最优化方法。其利用了目标函
数的泰勒展开式把非线性函数的最小二乘化问题化为每次迭代的线性函数的最小二乘化问题。高斯牛顿法的缺点在于：若初始点距离极小
值点过远，迭代步长过大会导致迭代下一代的函数值不一定小于上一代的函数值。所以在高斯牛顿法中加入了因子μ，当μ大时相当于梯度
下降法，μ小时相当于高斯牛顿法。（这儿我也不明白为什么，希望有大牛解答）。在使用Levenberg-Marquart时，先设置一个比较小的μ
值，当发现目标函数反而增大时，将μ增大使用梯度下降法快速寻找，然后再将μ减小使用牛顿法进行寻找。

牛顿法要比梯度下降法更具有全局判断能力梯度法从初始点的领域开始判断，在局部进行下降，然后步步逼近极值，往往是走之字型的。
牛顿法在二阶导数的作用下，从函数的凸性出发，直接搜索怎样到达极值点，也就是说在选择方向时，不仅考虑当前坡度是否够大，还会
考虑你走了一步之后，坡度是否会变得更大。从收敛速度来看，梯度下降是线性收敛，牛顿法是超线性的，至少二阶收敛～
 

特征选择
特征选择比较好理解，就是选择有用相关的属性，或者用另外一种表达方式：选择样本中有用、跟问题相关的特征。事实上这也很正常，
并不一定样本的所有属性对具体问题都是有用的，通过一定的方法选择合适的特征可以保证模型更优。常用的方法大致分三类：过滤式、包裹式和嵌入式。

降维
所谓的降维，即是多属性意味着是高维空间，在很多时候可以等价的映射到低维而不丢失主要信息。从空间映射的角度看，我们可以通过主成分
分析PCA（线性映射）和核化主成分分析（非线性映射）来达到降维的目的。（补充：PCA是无监督降维方法，线性判别分析LDA则是监督降维防范）


--------------------------------
###如何去选择回归模型
面对如此多的回归模型，最重要的是根据自变量因变量的类型、数据的维数和其他数据的重要特征去选择最合适的方法。以下是我们选择正确回归模型时要主要考虑的因素：

1.数据探索是建立预测模型不可或缺的部分。它应该是在选择正确模型之前要做的。

2.为了比较不同模型的拟合程度，我们可以分析不同的度量，比如统计*显著性参数、R方、调整R方、最小信息标准、BIC和误差准则。另一个是Mallow‘s Cp准则。*

3.交叉验证是验证预测模型最好的方法。你把你的数据集分成两组：一组用于训练，一组用于验证。

4.如果你的数据集有许多让你困惑的变量，你就不应该用自动模型选择方法，因为你不想把这些变量放在模型当中。

5.不强大的模型往往容易建立，而强大的模型很难建立。

6.回归正则方法在高维度和多重共线性的情况下表现的很好。


-----------------
###基本概念
训练集(training set/data)/训练样例（training examples): 用来进行训练，也就是产生模型或者算法的数据集
测试集(testing set/data)/测试样例 (testing examples)：用来专门进行测试已经学习好的模型或者算法的数据集
特征向量(features/feature vector)：属性的集合，通常用一个向量来表示，附属于一个实例
标记(label): c(x), 实例类别的标记
正例(positive example)
反例(negative example)

###机器学习类别
有监督学习(supervised learning)： 训练集有类别标记(class label)
无监督学习(unsupervised learning)： 无类别标记(class label)
半监督学习（semi-supervised learning)：有类别标记的训练集 + 无标记的训练集

###机器学习步骤框架
把数据拆分为训练集和测试集
用训练集和训练集的特征向量来训练算法
用学习来的算法运用在测试集上来评估算法 （可能要设计到调整参数（parameter tuning), 用验证集（validation set）




---------------------------------------------------------
###NLP大神推荐的机器学习入门书单（附大量百度网盘电子书）
http://www.tuicool.com/articles/IRBrMv

ML书单
│  李航.统计学习方法.pdf
│  机器学习及其应用.pdf
│  All of Statistics - A Concise Course in Statistical Inference - Larry Wasserman - Springer.pdf
│  Machine Learning - Tom Mitchell.pdf
│  PRML.pdf
│  PRML读书会合集打印版.pdf
│  Programming Collective Intelligence.pdf
│  [奥莱理] Machine Learning for Hackers.pdf
│  [机器学习]Tom.Mitchell.pdf
│  《大数据：互联网大规模数据挖掘与分布式处理》迷你书.pdf
│  推荐系统实践.pdf
│  数据挖掘-实用机器学习技术（中文第二版）.pdf
│  数据挖掘_概念与技术.pdf
│  机器学习-Mitchell-中文-清晰版.pdf
│  机器学习导论.pdf
│  模式分类第二版中文版Duda.pdf（全）.pdf
│  深入搜索引擎--海量信息的压缩、索引和查询.pdf
│  矩阵分析.美国 Roger.A.Horn.扫描版.pdf
│  统计学习基础 数据挖掘、推理与预测.pdf
│  
├─机器学习实战
│      machinelearninginaction.zip
│      机器学习实战 单页.pdf
│      机器学习实战.pdf
│      
└─论文文集
    └─LDA
            LDA-wangyi.pdf
            LDA数学八卦.pdf
            text-est.pdf
            
            
-**重点：矩阵论**-----------------------------------------------------------------            
文本隐语义分析
**TD-IDF矩阵转换奇异值分解SVD推导及应用**


###如何利用奇异值分解简化数据
http://www.ituring.com.cn/article/179996
SVD不仅是一个数学问题，在工程应用中的很多地方都有它的身影，比如前面讲的PCA，掌握了SVD原理后再去看PCA那是相当简单的，
在推荐系统方面，SVD更是名声大噪，将它应用于推荐系统的是Netflix大奖的获得者Koren，可以在Google上找到他写的文章；
用SVD可以很容易得到任意矩阵的满秩分解，用满秩分解可以对数据做压缩。可以用SVD来证明对任意M*N的矩阵均存在如下分解
A(m x n)=X(m x k)Y(k x n)


###机器学习中的数学(5)-强大的矩阵奇异值分解(SVD)及其应用
http://www.cnblogs.com/LeftNotEasy/archive/2011/01/19/svd-and-applications.html
PCA的实现一般有两种，一种是用特征值分解去实现的，一种是用奇异值分解去实现的


###[机器学习]机器学习之数学知识回顾-矩阵及优化理论
http://blog.csdn.net/u010536377/article/details/50252027
向量范数和矩阵范数、凸优化、拉格朗日对偶性


###矩阵的迹，矩阵求导
http://blog.sina.com.cn/s/blog_6cb263210101csq0.html


###机器学习中的数学(4)-线性判别分析（LDA）, 主成分分析(PCA)
http://www.cnblogs.com/LeftNotEasy/archive/2011/01/08/lda-and-pca-machine-learning.html











