

##Mahout�Ƽ��㷨API���
http://blog.csdn.net/zhoubl668/article/details/13297663/



Mahout��Դ��2008�꣬�����Apache Lucent������Ŀ�����ڼ��̵�ʱ����ȡ���˳���ķ�չ��������Apache�Ķ�����Ŀ��
Mahout����ҪĿ���Ǵ���һЩ����չ�Ļ���ѧϰ���򾭵��㷨��ʵ�֣�ּ�ڰ���������Ա���ӷ����ݵش�������Ӧ�ó���
Mahout�����Ѿ������˾��ࡢ���ࡢ�Ƽ����棨Эͬ���ˣ���Ƶ�����ھ�ȹ㷺ʹ�õ������ھ򷽷��������㷨��Mahout����������
������/������ߡ��������洢ϵͳ�������ݿ⡢MongoDB ��Cassandra�����ɵ������ھ�֧�ּܹ���

Mahoutѧϰ֮Mahout��顢��װ�����á����ų������
http://itindex.net/detail/49323-mahout-%E5%AD%A6%E4%B9%A0-mahout

Mahoutѧϰ·��ͼ
http://blog.fens.me/hadoop-mahout-roadmap/
 
��Maven����Mahout��Ŀ
http://blog.fens.me/hadoop-mahout-maven-eclipse/



--------------------------------
�ϴ���������
hadoop fs -put synthetic_control.data /user/root/testdata

ʹ��Mahout�е�kmeans�����㷨��ִ�����
mahout -core  org.apache.mahout.clustering.syntheticcontrol.kmeans.Job


-----------------------------------
###Mahout���þ��ࡢ�����Լ�Эͬ���˵��㷨������֮�⻹�У�
1. ���ھ���ֽ���Ƽ�ϵͳ
2. K-��ֵ��ģ��k-��ֵ�����㷨
3. �����������׷����㷨
4. ����ֵ�ֽ�
5. �߼��ع������
6. (����)���ر�Ҷ˹������
7. ���ɭ�ַ�����


---------------------------------
��Mahoutʵ�ֵĻ���ѧϰ�㷨��

�㷨��	�㷨��	������

�����㷨	
Logistic Regression	�߼��ع�
Bayesian	��Ҷ˹
SVM	֧��������
Perceptron	��֪���㷨
Neural Network	������
Random Forests	���ɭ��
Restricted Boltzmann Machines	���޲���������

�����㷨	
Canopy Clustering	Canopy����
K-means Clustering	K��ֵ�㷨
Fuzzy K-means	ģ��K��ֵ
Expectation Maximization	EM���ࣨ������󻯾��ࣩ
Mean Shift Clustering	��ֵƯ�ƾ���
Hierarchical Clustering	��ξ���
Dirichlet Process Clustering	������׹��̾���
Latent Dirichlet Allocation	LDA����
Spectral Clustering	�׾���

���������ھ�	
Parallel FP Growth Algorithm	����FP Growth�㷨

�ع�	
Locally Weighted Linear Regression	�ֲ���Ȩ���Իع�

��ά/άԼ��	
Singular Value Decomposition	����ֵ�ֽ�
Principal Components Analysis	���ɷַ���
Independent Component Analysis	�����ɷַ���
Gaussian Discriminative Analysis	��˹�б����

�����㷨	���л���Watchmaker���	

�Ƽ�/Эͬ����	
Non-distributed recommenders	Taste(UserCF, ItemCF, SlopeOne��
Distributed Recommenders	ItemCF

�������ƶȼ���	
RowSimilarityJob	�����м����ƶ�
VectorDistanceJob	�������������

��Map-Reduce�㷨	Hidden Markov Models	������Ʒ�ģ��

���Ϸ�����չ	Collections	��չ��java��Collections��



