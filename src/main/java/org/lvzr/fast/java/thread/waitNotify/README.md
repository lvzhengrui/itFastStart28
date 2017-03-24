##Java 多线程之线程间的通信——wait及notify方法

###线程间的相互作用
　　线程间的相互作用：线程之间需要一些协调通信，来共同完成一件任务。

　　Object类中相关的方法有两个notify方法和三个wait方法：

　　http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html

　　因为wait和notify方法定义在Object类中，因此会被所有的类所继承。

　　这些方法都是final的，即它们都是不能被重写的，不能通过子类覆写去改变它们的行为。

 
###wait()方法
　　wait()方法使得当前线程必须要等待，等到另外一个线程调用notify()或者notifyAll()方法。

　　当前的线程必须拥有当前对象的monitor，也即lock，就是锁。

　　线程调用wait()方法，释放它对锁的拥有权，然后等待另外的线程来通知它（通知的方式是notify()或者notifyAll()方法），
	这样它才能重新获得锁的拥有权和恢复执行。

　　要确保调用wait()方法的时候拥有锁，即，wait()方法的调用必须放在synchronized方法或synchronized块中。

 
　　一个小比较：

　　当线程调用了wait()方法时，它会释放掉对象的锁。

　　另一个会导致线程暂停的方法：Thread.sleep()，它会导致线程睡眠指定的毫秒数，但线程在睡眠的过程中是不会释放掉对象的锁的。

 
###notify()方法
　　notify()方法会唤醒一个等待当前对象的锁的线程。

　　如果多个线程在等待，它们中的一个将会选择被唤醒。这种选择是随意的，和具体实现有关。（线程等待一个对象的锁是由于调用了wait方法中的一个）。

　　被唤醒的线程是不能被执行的，需要等到当前线程放弃这个对象的锁。

　　被唤醒的线程将和其他线程以通常的方式进行竞争，来获得对象的锁。也就是说，被唤醒的线程并没有什么优先权，也没有什么劣势，
	对象的下一个线程还是需要通过一般性的竞争。

　　notify()方法应该是被拥有对象的锁的线程所调用。

　　（This method should only be called by a thread that is the owner of this object's monitor.）

　　换句话说，和wait()方法一样，notify方法调用必须放在synchronized方法或synchronized块中。

 

　　wait()和notify()方法要求在调用时线程已经获得了对象的锁，因此对这两个方法的调用需要放在synchronized方法或synchronized块中。

　　一个线程变为一个对象的锁的拥有者是通过下列三种方法：

　　1.执行这个对象的synchronized实例方法。

　　2.执行这个对象的synchronized语句块。这个语句块锁的是这个对象。

　　3.对于Class类的对象，执行那个类的synchronized、static方法。

