只需十四步：从零开始掌握Python机器学习（附资源）
http://www.admin5.com/article/20170320/727695.shtml

机器学习笔记整理全解
http://m.blog.csdn.net/article/details?id=69488610&from=singlemessage&isappinstalled=1


Scikit-learn的安装过程
http://blog.csdn.net/shizhixin/article/details/50488520
http://blog.csdn.net/skyinmoon/article/details/51790886


scikit-learn是一个基于NumPy、SciPy、Matplotlib的开源机器学习工具包，采用Python语言编写，主要涵盖分类、
回归和聚类等算法，例如knn、SVM、逻辑回归、朴素贝叶斯、随机森林、k-means等等诸多算法，官网上代码和文档
都非常不错，对于机器学习开发者来说，是一个使用方便而强大的工具，节省不少开发时间。


-----------------------
###基于Python机器学习常用库
http://blog.csdn.net/baihuaxiu123/article/details/60768806

基于Scikit learn库中KNN,SVM算法的笔迹识别
http://blog.csdn.net/baihuaxiu123/article/details/59490346


----------------------
###scikit-learn安装

下载：http://peak.telecommunity.com/dist/ez_setup.py

ez_setup.py放在C:\Python27目录

C:\Python27>python ez_setup.py

C:\Python27\Scripts>easy_install pip


到http://www.lfd.uci.edu/~gohlke/pythonlibs/下载并用pip按顺序安装 
numpy-1.11.1+mkl-cp27-cp27m-win_amd64.whl
scipy-0.17.1-cp27-cp27m-win_amd64.whl
matplotlib-1.5.1-cp27-none-win_amd64.whl
scikit_learn-0.17.1-cp27-cp27m-win_amd64.whl
     
C:\Python27\Scripts>pip install numpy-1.11.1+mkl-cp27-cp27m-win_amd64.whl
C:\Python27\Scripts>pip install scipy-0.17.1-cp27-cp27m-win_amd64.whl
C:\Python27\Scripts>pip install matplotlib-1.5.1-cp27-none-win_amd64.whl
C:\Python27\Scripts>pip install scikit_learn-0.17.1-cp27-cp27m-win_amd64.whl(或easy_install scikit-learn)


---------------------
###机器学习之Python之NumPy数学库的介绍
http://blog.csdn.net/baihuaxiu123/article/details/59575572
>>>import numpy as np
>>>c = np.array([[1, 2, 3, 4],[4, 5, 6, 7], [7, 8, 9, 10]])
>>>a.shape = 2,-1
>>>d = a.reshape((2,6) #a,d共享内存区域

np.arange(10)
np.arange(0,1,0.1)
np.linspace(0, 1, 12)
np.logspace(0, 2, 20)

np.fromstring(s, dtype=np.int8)
np.frombuffer
np.fromfile
np.fromfunction(func, (10,))

a = np.arange(10)

>>> a[5]    # 用整数作为下标可以获取数组中的某个元素
5

>>> a[3:5]  # 用范围作为下标获取数组的一个切片，包括a[3]不包括a[5]
array([3, 4])

>>> a[:5]   # 省略开始下标，表示从a[0]开始
array([0, 1, 2, 3, 4])

>>> a[:-1]  # 下标可以使用负数，表示从数组后往前数
array([0, 1, 2, 3, 4, 5, 6, 7, 8])
>>> a[2:4] = 100,101    # 下标还可以用来修改元素的值
>>> a
array([  0,   1, 100, 101,   4,   5,   6,   7,   8,   9])

>>> a[1:-1:2]   # 范围中的第三个参数表示步长，2表示隔一个元素取一个元素
array([  1, 101,   5,   7])

>>> a[::-1] # 省略范围的开始下标和结束下标，步长为-1，整个数组头尾颠倒
array([  9,   8,   7,   6,   5,   4, 101, 100,   1,   0])

>>> a[5:1:-2] # 步长为负数时，开始下标必须大于结束下标
array([  5, 101])

x = np.arange(10,1,-1)
b = x[np.array([3,3,-3,8])] 
x[np.array([True, False, True, False, False])]
x[[True, False, True, False, False]]

x = np.random.rand(10) 
x[x>0.5]


---------------------
###机器学习库Sklearn详解
http://blog.csdn.net/baihuaxiu123/article/details/62429164

基于 Python 和 Scikit-Learn 的机器学习介绍
http://developer.51cto.com/art/201507/485276.htm

Scikit-Learn机器学习介绍
http://www.tuicool.com/articles/qeIzI3F

scikit-learn Machine Learning in Python
http://scikit-learn.org/stable/

Generalized Linear Models
http://scikit-learn.org/stable/modules/linear_model.html#logistic-regression

scikit-learn数据集
http://scikit-learn.org/stable/datasets/index.html#datasets

pickle持久化模型
http://scikit-learn.org/stable/modules/model_persistence.html#model-persistence

Persistence joblib
https://pythonhosted.org/joblib/persistence.html

-------------------------------------
scikit-learn有一些标准数据集，比如用于分类的 iris 和 digits 数据集，和用于回归的 波士顿房价 (boston house prices)数据集。
>>> from sklearn import datasets
>>> iris = datasets.load_iris()
>>> print(digits.data) 
>>> print(digits.target)   

>>> digits = datasets.load_digits()
>>> digits.images[0]

在scikit-learn中，分类的预测器是一个Python对象，来实现fit(X, y)和predict(T)方法。
>>>from sklearn import svm
>>>clf = svm.SVC(gamma=0.001, C=100.)
>>>clf.fit(digits.data[:-1], digits.target[:-1])
>>>clf.predict(digits.data[-1])

pickle持久化模型
http://scikit-learn.org/stable/modules/model_persistence.html#model-persistence
>>> import pickle
>>> s = pickle.dumps(clf)
>>> clf2 = pickle.loads(s)
>>> clf2.predict(X[0])
array([0])
>>> y[0]
  
joblib持久化模型
>>> from sklearn.externals import joblib
>>> joblib.dump(clf, 'filename.pkl') # doctest: +SKIP
>>> clf = joblib.load('filename.pkl') # doctest:+SKIP

















