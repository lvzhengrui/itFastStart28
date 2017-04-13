
Spark MLlibϵ��(һ)�����Ž���
http://blog.csdn.net/shifenglov/article/details/43762705

Machine Learning Library (MLlib) Programming Guide
http://spark.apache.org/docs/1.2.0/mllib-guide.html


��������--Spark����ʵսϵ��
http://www.cnblogs.com/shishanyuan/p/4699644.html

Spark����ʵսϵ��--8.Spark MLlib���ϣ�--����ѧϰ��SparkMLlib���
http://www.cnblogs.com/shishanyuan/p/4747761.html



---------------------------------------
MLlib ��Spark�Ŀ�����չ�Ļ���ѧϰ�⣬�����²�����ɣ�ͨ�õ�ѧϰ�㷨�͹����࣬�������࣬�ع飬���࣬Эͬ���ˣ���ά����ȻҲ�������ŵĲ���
Data types  

Basic statistics  (����ͳ��)
	summary statistics ����ͳ��
	correlations �����
	stratified sampling �ֲ�ȡ��
	hypothesis testing �������
	random data generation ���������
	
Classification and regression   (����һ�������ɢ�����ݶ��Եģ��ع���������������ݵġ���������һ����)
	linear models (SVMs, logistic regression, linear regression) ����ģ�ͣ�֧�����������߼��ع飬���Իع飩
	naive Bayes ��Ҷ˹�㷨
	decision trees  ������
	ensembles of trees (Random Forests and Gradient-Boosted Trees) �����������ɭ�ֺ��ݶ���ǿ����

Collaborative filtering   Эͬ����
	alternating least squares (ALS)  (������С���˷�(ALS) )

Clustering  ����
	k-means k��ֵ�㷨

Dimensionality reduction   (��ά)
	singular value decomposition (SVD)  ����ֵ�ֽ�
	principal component analysis (PCA) ���ɷַ���

Feature extraction and transformation ������ȡ��ת��

Optimization (developer) �Ż�����
	stochastic gradient descent ����ݶ��½�
	limited-memory BFGS (L-BFGS) ��ʱ�����BFGS (��ţ�ٷ��е�һ��,�������������)

MLlib��ǰ�ڷǳ���Ծ�Ŀ�������£�������Щ����ǳ� Experimental/DeveloperApi ��δ���ķ����ֿ��ܻᱻ�޸�

����
MLlibʹ�������Դ����� Breeze, ��������netlib-java��jblas��netlib-java �� jblas ��Ҫ����native Fortran routines��
��������Ҫ��װgfortran runtime library ����װ��������������У��������ļ�Ⱥ�Ľڵ���û�а�װnative Fortran routines��
MLlib ���׳�һ��link error�����û�а�װnative Fortran routines��

�������Ҫʹ��spark��python����������Ҫ NumPy version 1.4�����ϰ汾.


��ǰ����汾1.2
������Ϊ��ǰ1.2�汾�����ĸĽ�Ӧ���Ƿ����˳�Ϊspark.ml�Ļ���ѧϰ���߰���֧����pipeline��ѧϰģʽ��������㷨�����ò�ͬ������
��ˮ�ߵ���ʽ���С��ڹ�ҵ��Ļ���ѧϰӦ�ò�������У�pipeline�Ĺ���ģʽ�Ǻܳ����ġ��µ�ML���߰�ʹ��Spark��SchemaRDD����
ʾ����ѧϰ�����ݼ��ϣ��ṩ��Spark SQLֱ�ӷ��ʵĽӿڡ����⣬�ڻ���ѧϰ���㷨���棬�����������������ķ��������ɭ�ֺ���
����ǿ��������ò�����������Ż�������һƪDataBricks��ppt����˵1.2�汾���㷨�������ϱ�1.1�汾ƽ������3��


-------------------------------------------
MLlib����RDD�������Ϳ�����Spark SQL��GraphX��Spark Streaming�޷켯�ɣ���RDDΪ��ʯ��4���ӿ�ܿ����ֹ��������ݼ������ģ�

MLlib��MLBaseһ���֣�����MLBase��Ϊ�Ĳ��֣�MLlib��MLI��ML Optimizer��MLRuntime��

ML Optimizer��ѡ������Ϊ���ʺϵ��Ѿ����ڲ�ʵ�ֺ��˵Ļ���ѧϰ�㷨����ز������������û���������ݣ�������ģ�ͻ��İ��������Ľ����

MLI ��һ������������ȡ�͸߼�ML��̳�����㷨ʵ�ֵ�API��ƽ̨��

MLlib��Sparkʵ��һЩ�����Ļ���ѧϰ�㷨��ʵ�ó��򣬰������ࡢ�ع顢���ࡢЭͬ���ˡ���ά�Լ��ײ��Ż������㷨���Խ��п����䣻 
MLRuntime ����Spark�����ܣ���Spark�ķֲ�ʽ����Ӧ�õ�����ѧϰ����



-----------------------------------------------
���Իع�������������̿��Լ�����Ϊ�����������裺

��1��Ѱ�Һ��ʵ�Ԥ�⺯�����������е� h(x) ������Ԥ���������ݵ��жϽ������������Ƿǳ��ؼ��ģ���Ҫ��������һ�����˽�������֪�����߲²�
Ԥ�⺯���ġ���š���ʽ�����������Ժ������Ƿ����Ժ��������Ƿ����Ե����޷������Իع����ó��������Ľ����

��2������һ��Loss��������ʧ���������ú�����ʾԤ��������h����ѵ�����ݱ�ǩ֮���ƫ������Ƕ���֮��Ĳh-y����������������ʽ����ƽ�������
���ۺϿ�������ѵ�����ݵġ���ʧ������Loss��ͻ�����ƽ������Ϊ J(��) ��������ʾ����ѵ������Ԥ��ֵ��ʵ������ƫ�

��3����Ȼ�� J(��) ������ֵԽС��ʾԤ�⺯��Խ׼ȷ����h����Խ׼ȷ����������һ����Ҫ�������ҵ� J(��) ��������Сֵ���Һ�������Сֵ�в�ͬ�ķ�����
Spark�в��õ����ݶ��½�����stochastic gradient descent��SGD)��






































