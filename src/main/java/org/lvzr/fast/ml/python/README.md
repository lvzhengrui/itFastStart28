ֻ��ʮ�Ĳ������㿪ʼ����Python����ѧϰ������Դ��
http://www.admin5.com/article/20170320/727695.shtml

����ѧϰ�ʼ�����ȫ��
http://m.blog.csdn.net/article/details?id=69488610&from=singlemessage&isappinstalled=1


Scikit-learn�İ�װ����
http://blog.csdn.net/shizhixin/article/details/50488520
http://blog.csdn.net/skyinmoon/article/details/51790886


scikit-learn��һ������NumPy��SciPy��Matplotlib�Ŀ�Դ����ѧϰ���߰�������Python���Ա�д����Ҫ���Ƿ��ࡢ
�ع�;�����㷨������knn��SVM���߼��ع顢���ر�Ҷ˹�����ɭ�֡�k-means�ȵ�����㷨�������ϴ�����ĵ�
���ǳ��������ڻ���ѧϰ��������˵����һ��ʹ�÷����ǿ��Ĺ��ߣ���ʡ���ٿ���ʱ�䡣


-----------------------
###����Python����ѧϰ���ÿ�
http://blog.csdn.net/baihuaxiu123/article/details/60768806

����Scikit learn����KNN,SVM�㷨�ıʼ�ʶ��
http://blog.csdn.net/baihuaxiu123/article/details/59490346


----------------------
###scikit-learn��װ

���أ�http://peak.telecommunity.com/dist/ez_setup.py

ez_setup.py����C:\Python27Ŀ¼

C:\Python27>python ez_setup.py

C:\Python27\Scripts>easy_install pip


��http://www.lfd.uci.edu/~gohlke/pythonlibs/���ز���pip��˳��װ 
numpy-1.11.1+mkl-cp27-cp27m-win_amd64.whl
scipy-0.17.1-cp27-cp27m-win_amd64.whl
matplotlib-1.5.1-cp27-none-win_amd64.whl
scikit_learn-0.17.1-cp27-cp27m-win_amd64.whl
     
C:\Python27\Scripts>pip install numpy-1.11.1+mkl-cp27-cp27m-win_amd64.whl
C:\Python27\Scripts>pip install scipy-0.17.1-cp27-cp27m-win_amd64.whl
C:\Python27\Scripts>pip install matplotlib-1.5.1-cp27-none-win_amd64.whl
C:\Python27\Scripts>pip install scikit_learn-0.17.1-cp27-cp27m-win_amd64.whl(��easy_install scikit-learn)


---------------------
###����ѧϰ֮Python֮NumPy��ѧ��Ľ���
http://blog.csdn.net/baihuaxiu123/article/details/59575572
>>>import numpy as np
>>>c = np.array([[1, 2, 3, 4],[4, 5, 6, 7], [7, 8, 9, 10]])
>>>a.shape = 2,-1
>>>d = a.reshape((2,6) #a,d�����ڴ�����

np.arange(10)
np.arange(0,1,0.1)
np.linspace(0, 1, 12)
np.logspace(0, 2, 20)

np.fromstring(s, dtype=np.int8)
np.frombuffer
np.fromfile
np.fromfunction(func, (10,))

a = np.arange(10)

>>> a[5]    # ��������Ϊ�±���Ի�ȡ�����е�ĳ��Ԫ��
5

>>> a[3:5]  # �÷�Χ��Ϊ�±��ȡ�����һ����Ƭ������a[3]������a[5]
array([3, 4])

>>> a[:5]   # ʡ�Կ�ʼ�±꣬��ʾ��a[0]��ʼ
array([0, 1, 2, 3, 4])

>>> a[:-1]  # �±����ʹ�ø�������ʾ���������ǰ��
array([0, 1, 2, 3, 4, 5, 6, 7, 8])
>>> a[2:4] = 100,101    # �±껹���������޸�Ԫ�ص�ֵ
>>> a
array([  0,   1, 100, 101,   4,   5,   6,   7,   8,   9])

>>> a[1:-1:2]   # ��Χ�еĵ�����������ʾ������2��ʾ��һ��Ԫ��ȡһ��Ԫ��
array([  1, 101,   5,   7])

>>> a[::-1] # ʡ�Է�Χ�Ŀ�ʼ�±�ͽ����±꣬����Ϊ-1����������ͷβ�ߵ�
array([  9,   8,   7,   6,   5,   4, 101, 100,   1,   0])

>>> a[5:1:-2] # ����Ϊ����ʱ����ʼ�±������ڽ����±�
array([  5, 101])

x = np.arange(10,1,-1)
b = x[np.array([3,3,-3,8])] 
x[np.array([True, False, True, False, False])]
x[[True, False, True, False, False]]

x = np.random.rand(10) 
x[x>0.5]


---------------------
###����ѧϰ��Sklearn���
http://blog.csdn.net/baihuaxiu123/article/details/62429164

���� Python �� Scikit-Learn �Ļ���ѧϰ����
http://developer.51cto.com/art/201507/485276.htm

Scikit-Learn����ѧϰ����
http://www.tuicool.com/articles/qeIzI3F

scikit-learn Machine Learning in Python
http://scikit-learn.org/stable/

Generalized Linear Models
http://scikit-learn.org/stable/modules/linear_model.html#logistic-regression

scikit-learn���ݼ�
http://scikit-learn.org/stable/datasets/index.html#datasets

pickle�־û�ģ��
http://scikit-learn.org/stable/modules/model_persistence.html#model-persistence

Persistence joblib
https://pythonhosted.org/joblib/persistence.html

-------------------------------------
scikit-learn��һЩ��׼���ݼ����������ڷ���� iris �� digits ���ݼ��������ڻع�� ��ʿ�ٷ��� (boston house prices)���ݼ���
>>> from sklearn import datasets
>>> iris = datasets.load_iris()
>>> print(digits.data) 
>>> print(digits.target)   

>>> digits = datasets.load_digits()
>>> digits.images[0]

��scikit-learn�У������Ԥ������һ��Python������ʵ��fit(X, y)��predict(T)������
>>>from sklearn import svm
>>>clf = svm.SVC(gamma=0.001, C=100.)
>>>clf.fit(digits.data[:-1], digits.target[:-1])
>>>clf.predict(digits.data[-1])

pickle�־û�ģ��
http://scikit-learn.org/stable/modules/model_persistence.html#model-persistence
>>> import pickle
>>> s = pickle.dumps(clf)
>>> clf2 = pickle.loads(s)
>>> clf2.predict(X[0])
array([0])
>>> y[0]
  
joblib�־û�ģ��
>>> from sklearn.externals import joblib
>>> joblib.dump(clf, 'filename.pkl') # doctest: +SKIP
>>> clf = joblib.load('filename.pkl') # doctest:+SKIP

















