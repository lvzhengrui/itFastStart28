
###ʮ�������Java�еĶ�̬����
http://www.jb51.net/article/86531.htm

###�������JAVA��̬����
http://www.cnblogs.com/flyoung2008/archive/2013/08/11/3251148.html

-------------------------------------
java.lang.reflect.Proxy
Proxy �ṩ���ڴ�����̬�������ʵ���ľ�̬����.
newProxyInstance()

java.lang.reflect.InvocationHandler,
InvocationHandler �Ǵ���ʵ���ĵ��ô������ ʵ�ֵĽӿڡ� 
invoke()


-------------------------------------
###�ܽ�
һ�����͵Ķ�̬������������̿ɷ�Ϊ�����ĸ����裺
1��ͨ��ʵ��InvocationHandler�ӿڴ����Լ��ĵ��ô����� IvocationHandler handler = new InvocationHandlerImpl(...);

2��ͨ��ΪProxy��ָ��ClassLoader�����һ��interface������̬������
	Class clazz = Proxy.getProxyClass(classLoader,new Class[]{...});

3��ͨ��������ƻ�ȡ��̬������Ĺ��캯��������������ǵ��ô������ӿ�����
	Constructor constructor = clazz.getConstructor(new Class[]{InvocationHandler.class});

4��ͨ�����캯������������ʵ������ʱ�轫���ô�����������Ϊ����������

Interface Proxy = (Interface)constructor.newInstance(new Object[] (handler));
Ϊ�˼򻯶��󴴽����̣�Proxy���е�newInstance������װ��2~4��ֻ������������ɴ������Ĵ�����
���ɵ�ProxySubject�̳�Proxy��ʵ��Subject�ӿڣ�ʵ�ֵ�Subject�ķ���ʵ�ʵ��ô�������invoke������
��invoke�������÷�����õ��Ǳ��������ĵķ�����Object result=method.invoke(proxied,args)��

###���в���
��Ȼ��Proxy�Ѿ���Ƶ÷ǳ����������ǻ�����һ���СС���ź�֮�����Ǿ�����ʼ���޷����ѽ�֧��interface�����������
��Ϊ�������ע��������ź�������һ����Щ��̬���ɵĴ�����ļ̳й�ϵͼ�������Ѿ�ע����һ����ͬ�ĸ����Proxy��Java�ļ̳�
����ע������Щ��̬���������޷�ʵ�ֶ�class�Ķ�̬����ԭ���Ƕ�̳���Java�б����Ͼ��в�ͨ���кܶ������ɣ����ǿ��Է񶨶� 
class����ı�Ҫ�ԣ�����ͬ����һЩ���ɣ�����֧��class��̬���������á��ӿں���Ļ��֣����Ͳ��Ǻ����ԣ�ֻ�ǵ���Java�вű����
�˵�ϸ�������ֻ�ӷ������������Ƿ񱻶�������������һ�����ߵĻ���壬�������ֽг����ࡣʵ�ֶԳ�����Ķ�̬��������Ҳ��������
�ļ�ֵ�����⣬����һЩ��ʷ�������࣬���ǽ���Ϊû��ʵ���κνӿڶ��Ӵ��붯̬����������Ե��������֣����ò�˵��һ��СС���ź���
���ǣ��������������ڲ�ΰ��ΰ����һ�ֱ��ʣ�Java��̬�������������












