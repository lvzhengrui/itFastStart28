

Spark�ʼǣ�RDD�����������ϣ�
http://www.cnblogs.com/sharpxiajun/p/5506822.html
 
Spark�ʼǣ�RDD�����������£�
http://www.cnblogs.com/sharpxiajun/p/5510215.html
 
 

-----------------------------------
Spark������Ļ������ʲô��RDD 
http://www.tuicool.com/articles/3QzyYb
 
http://shiyanjun.cn/archives/744.html 
RDD�������ڴ�ļ�Ⱥ�����ݴ����
 

 

 
------------------------------------ 
###��δ���RDD��
RDD���Դ���ͨ���鴴��������Ҳ���Դ��ļ�ϵͳ����HDFS�е��ļ�����������

����������ͨ���鴴��RDD�����������1��9��9�����֣����Ƿֱ���3�������С�

scala> val a = sc.parallelize(1 to 9, 3)
a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[1] at parallelize at <console>:12
��������ȡ�ļ�README.md������RDD���ļ��е�ÿһ�о���RDD�е�һ��Ԫ��

scala> val b = sc.textFile("README.md")
b: org.apache.spark.rdd.RDD[String] = MappedRDD[3] at textFile at <console>:12
��Ȼ���б�ķ�ʽ���Դ���RDD�����ڱ�����������Ҫʹ���������ַ�ʽ������RDD��˵��RDD��API��


###map
map�Ƕ�RDD�е�ÿ��Ԫ�ض�ִ��һ��ָ���ĺ���������һ���µ�RDD���κ�ԭRDD�е�Ԫ������RDD�ж�����ֻ��һ��Ԫ����֮��Ӧ��

������

scala> val a = sc.parallelize(1 to 9, 3)
scala> val b = a.map(x => x*2)
scala> a.collect
res10: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
scala> b.collect
res11: Array[Int] = Array(2, 4, 6, 8, 10, 12, 14, 16, 18)
���������а�ԭRDD��ÿ��Ԫ�ض�����2������һ���µ�RDD��


###mapPartitions
mapPartitions��map��һ�����֡�map�����뺯����Ӧ����RDD��ÿ��Ԫ�أ���mapPartitions�����뺯����Ӧ����ÿ��������
Ҳ���ǰ�ÿ�������е�������Ϊ����������ġ� 
���ĺ�������Ϊ��

def mapPartitions[U: ClassTag](f: Iterator[T] => Iterator[U], preservesPartitioning: Boolean = false): RDD[U]
f��Ϊ���뺯����������ÿ��������������ݡ�ÿ�������е����ݽ���Iterator[T]���ݸ����뺯��f��f����������Iterator[U]��
���յ�RDD�����з����������뺯�������Ľ���ϲ������ġ�

������

scala> val a = sc.parallelize(1 to 9, 3)
scala> def myfunc[T](iter: Iterator[T]) : Iterator[(T, T)] = {
    var res = List[(T, T)]() 
    var pre = iter.next while (iter.hasNext) {
        val cur = iter.next; 
        res .::= (pre, cur) pre = cur;
    } 
    res.iterator
}
scala> a.mapPartitions(myfunc).collect
res0: Array[(Int, Int)] = Array((2,3), (1,2), (5,6), (4,5), (8,9), (7,8))
���������еĺ���myfunc�ǰѷ�����һ��Ԫ�غ�������һ��Ԫ�����һ��Tuple����Ϊ���������һ��Ԫ��û����һ��Ԫ���ˣ�����(3,4)��(6,7)���ڽ���С� 
mapPartitions����Щ���֣�����mapPartitionsWithContext�����ܰѴ�������е�һЩ״̬��Ϣ���ݸ��û�ָ�������뺯����
����mapPartitionsWithIndex�����ܰѷ�����index���ݸ��û�ָ�������뺯����


###mapValues
mapValues����˼��������뺯��Ӧ����RDD��Kev-Value��Value��ԭRDD�е�Key���ֲ��䣬���µ�Valueһ������µ�RDD�е�Ԫ�ء�
��ˣ��ú���ֻ������Ԫ��ΪKV�Ե�RDD��

������

scala> val a = sc.parallelize(List("dog", "tiger", "lion", "cat", "panther", " eagle"), 2)
scala> val b = a.map(x => (x.length, x))
scala> b.mapValues("x" + _ + "x").collect
res5: Array[(Int, String)] = Array((3,xdogx), (5,xtigerx), (4,xlionx),(3,xcatx), (7,xpantherx), (5,xeaglex))



###mapWith
mapWith��map������һ�����֣�mapֻ��Ҫһ�����뺯������mapWith���������뺯�������Ķ������£�

def mapWith[A: ClassTag, U: ](constructA: Int => A, preservesPartitioning: Boolean = false)(f: (T, A) => U): RDD[U]

��һ������constructA�ǰ�RDD��partition index��index��0��ʼ����Ϊ���룬���Ϊ������A��

�ڶ�������f�ǰѶ�Ԫ��(T, A)��Ϊ���루����TΪԭRDD�е�Ԫ�أ�AΪ��һ����������������������ΪU��

��������partition index ����10��Ȼ�����2��Ϊ�µ�RDD��Ԫ�ء�

val x = sc.parallelize(List(1,2,3,4,5,6,7,8,9,10), 3) 

x.mapWith(a => a * 10)((a, b) => (b + 2)).collect 

res4: Array[Int] = Array(2, 2, 2,   12, 12, 12,   22, 22, 22, 22)



###flatMap
��map���ƣ�������ԭRDD�е�Ԫ�ؾ�map�����ֻ������һ��Ԫ�أ���ԭRDD�е�Ԫ�ؾ�flatmap���������ɶ��Ԫ����������RDD�� 
��������ԭRDD�е�ÿ��Ԫ��x����y��Ԫ�أ���1��y��yΪԪ��x��ֵ��

scala> val a = sc.parallelize(1 to 4, 2)
scala> val b = a.flatMap(x => 1 to x)
scala> b.collect
res12: Array[Int] = Array(1, 1, 2, 1, 2, 3, 1, 2, 3, 4)
flatMapWith

flatMapWith��mapWith�����ƣ����ǽ�������������һ��������partitionIndex��Ϊ���룬�����һ��������A������һ���������Զ�Ԫ�飨T,A��
��Ϊ���룬���Ϊһ�����У���Щ���������Ԫ��������µ�RDD�����Ķ������£�

def flatMapWith[A: ClassTag, U: ClassTag](constructA: Int => A, preservesPartitioning: Boolean = false)(f: (T, A) => Seq[U]): RDD[U]
������

scala> val a = sc.parallelize(List(1,2,3,4,5,6,7,8,9), 3)
scala> a.flatMapWith(x => x, true)((x, y) => List(y, x)).collect
res58: Array[Int] = Array(0, 1, 0, 2, 0, 3, 1, 4, 1, 5, 1, 6, 2, 7, 2,
8, 2, 9)



###flatMapValues
flatMapValues������mapValues����ͬ������flatMapValuesӦ����Ԫ��ΪKV�Ե�RDD��Value��ÿ��һԪ�ص�Value�����뺯��ӳ��Ϊһϵ�е�ֵ��
Ȼ����Щֵ����ԭRDD�е�Key���һϵ���µ�KV�ԡ�

����

scala> val a = sc.parallelize(List((1,2),(3,4),(3,6)))
scala> val b = a.flatMapValues(x=>x.to(5))
scala> b.collect
res3: Array[(Int, Int)] = Array((1,2), (1,3), (1,4), (1,5), (3,4), (3,5))
����������ԭRDD��ÿ��Ԫ�ص�ֵ��ת��Ϊһ�����У����䵱ǰֵ��5���������һ��KV��(1,2), ��ֵ2��ת��Ϊ2��3��4��5��Ȼ��������ԭKV����Key
���һϵ���µ�KV��(1,2),(1,3),(1,4),(1,5)��


###reduce
reduce��RDD��Ԫ���������ݸ����뺯����ͬʱ����һ���µ�ֵ���²�����ֵ��RDD����һ��Ԫ���ٱ����ݸ����뺯��ֱ�����ֻ��һ��ֵΪֹ��

����

scala> val c = sc.parallelize(1 to 10)
scala> c.reduce((x, y) => x + y)
res4: Int = 55
�������Ӷ�RDD�е�Ԫ����͡�



###reduceByKey
����˼�壬reduceByKey���Ƕ�Ԫ��ΪKV�Ե�RDD��Key��ͬ��Ԫ�ص�Value����reduce����ˣ�Key��ͬ�Ķ��Ԫ�ص�ֵ��reduceΪһ��ֵ��
Ȼ����ԭRDD�е�Key���һ���µ�KV�ԡ�

����:

scala> val a = sc.parallelize(List((1,2),(3,4),(3,6)))
scala> a.reduceByKey((x,y) => x + y).collect
res7: Array[(Int, Int)] = Array((1,2), (3,10))
���������У���Key��ͬ��Ԫ�ص�ֵ��ͣ����KeyΪ3������Ԫ�ر�תΪ��(3,10)��


