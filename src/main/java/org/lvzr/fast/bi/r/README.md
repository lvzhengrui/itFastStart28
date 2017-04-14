
###R��������
http://www.yiibai.com/r/r_basic_syntax.html


###��R����ʵ��Kmeans�㷨
������Ϊ���ý����ֱ�ۣ���������R���ԣ�����kmeansʵ�飬������ͬ�����ݡ�

R���Դ��룺

> y<-read.csv(file="randomData.csv",sep=",",header=FALSE) 
> cl<-kmeans(y,3,iter.max = 10, nstart = 25) 
> cl$centers
          V1         V2
1 -0.4323971  2.2852949
2  0.9023786 -0.7011153
3  4.3725463  2.4622609

# ���ɾ������ĵ�ͼ��
> plot(y, col=c("black","blue","green")[cl$cluster])
> points(cl$centers, col="red", pch = 19)

# ����Mahout���������
> mahout<-matrix(c(-2.686856800552941,1.8939462954763795,0.6334255423230666,0.49472852972602105,3.334520309711998,3.2758355898247653),ncol=2,byrow=TRUE) 
> points(mahout, col="violetred", pch = 19)

