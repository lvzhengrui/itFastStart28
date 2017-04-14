
###R语言入门
http://www.yiibai.com/r/r_basic_syntax.html


###用R语言实现Kmeans算法
接下来为了让结果更直观，我们再用R语言，进行kmeans实验，操作相同的数据。

R语言代码：

> y<-read.csv(file="randomData.csv",sep=",",header=FALSE) 
> cl<-kmeans(y,3,iter.max = 10, nstart = 25) 
> cl$centers
          V1         V2
1 -0.4323971  2.2852949
2  0.9023786 -0.7011153
3  4.3725463  2.4622609

# 生成聚类中心的图形
> plot(y, col=c("black","blue","green")[cl$cluster])
> points(cl$centers, col="red", pch = 19)

# 画出Mahout聚类的中心
> mahout<-matrix(c(-2.686856800552941,1.8939462954763795,0.6334255423230666,0.49472852972602105,3.334520309711998,3.2758355898247653),ncol=2,byrow=TRUE) 
> points(mahout, col="violetred", pch = 19)

