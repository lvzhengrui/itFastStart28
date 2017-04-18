

###Vector
Vector与ArrayList一样，也是通过数组实现的，不同的是它支持线程的同步，即某一时刻只有一个线程能够写Vector，
避免多线程同时写而引起的不一致性，但实现同步需要很高的花费，因此，访问它比访问ArrayList慢。


###使用Java序列化把对象存储到文件中，ObjectOutputStream和ObjectInputStream来进行对象的读取
http://blog.csdn.net/it_wangxiangpan/article/details/5781941


###volatile
一个定义为volatile的变量是说这变量可能会被意想不到地改变，这样，编译器就不会去假设这个变量的值了。精确地说就是，
优化器在用到这个变量时必须每次都小心地重新读取这个变量的值，而不是使用保存在寄存器里的备份




