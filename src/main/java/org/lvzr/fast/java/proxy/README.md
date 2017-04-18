
###十分钟理解Java中的动态代理
http://www.jb51.net/article/86531.htm

###彻底理解JAVA动态代理
http://www.cnblogs.com/flyoung2008/archive/2013/08/11/3251148.html

-------------------------------------
java.lang.reflect.Proxy
Proxy 提供用于创建动态代理类和实例的静态方法.
newProxyInstance()

java.lang.reflect.InvocationHandler,
InvocationHandler 是代理实例的调用处理程序 实现的接口。 
invoke()


-------------------------------------
###总结
一个典型的动态代理创建对象过程可分为以下四个步骤：
1、通过实现InvocationHandler接口创建自己的调用处理器 IvocationHandler handler = new InvocationHandlerImpl(...);

2、通过为Proxy类指定ClassLoader对象和一组interface创建动态代理类
	Class clazz = Proxy.getProxyClass(classLoader,new Class[]{...});

3、通过反射机制获取动态代理类的构造函数，其参数类型是调用处理器接口类型
	Constructor constructor = clazz.getConstructor(new Class[]{InvocationHandler.class});

4、通过构造函数创建代理类实例，此时需将调用处理器对象作为参数被传入

Interface Proxy = (Interface)constructor.newInstance(new Object[] (handler));
为了简化对象创建过程，Proxy类中的newInstance方法封装了2~4，只需两步即可完成代理对象的创建。
生成的ProxySubject继承Proxy类实现Subject接口，实现的Subject的方法实际调用处理器的invoke方法，
而invoke方法利用反射调用的是被代理对象的的方法（Object result=method.invoke(proxied,args)）

###美中不足
诚然，Proxy已经设计得非常优美，但是还是有一点点小小的遗憾之处，那就是它始终无法摆脱仅支持interface代理的桎梏，
因为它的设计注定了这个遗憾。回想一下那些动态生成的代理类的继承关系图，它们已经注定有一个共同的父类叫Proxy。Java的继承
机制注定了这些动态代理类们无法实现对class的动态代理，原因是多继承在Java中本质上就行不通。有很多条理由，人们可以否定对 
class代理的必要性，但是同样有一些理由，相信支持class动态代理会更美好。接口和类的划分，本就不是很明显，只是到了Java中才变得如
此的细化。如果只从方法的声明及是否被定义来考量，有一种两者的混合体，它的名字叫抽象类。实现对抽象类的动态代理，相信也有其内在
的价值。此外，还有一些历史遗留的类，它们将因为没有实现任何接口而从此与动态代理永世无缘。如此种种，不得不说是一个小小的遗憾。
但是，不完美并不等于不伟大，伟大是一种本质，Java动态代理就是佐例。












