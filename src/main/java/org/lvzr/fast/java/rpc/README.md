
###Hadoop RPC框架
http://blog.csdn.net/thomas0yang/article/details/41211259

###hadoop源码研读之路（四）----IPC.RPC
http://blog.csdn.net/a15039096218/article/details/7615191

###远程通信的几种选择（RPC，Webservice，RMI，JMS，CORBA的区别）
http://blog.csdn.net/shan9liang/article/details/8995023



###深入浅出JMS(一)--JMS基本概念
http://blog.csdn.net/jiuqiyuliang/article/details/46701559




-----------------------------------------------------------------
###Hadoop实现了基于IPC模型的RPC机制

ipc是inter process call，就是进程间通信，可以为进程交换数据服务，rpc是remote process call，
可以为主机间的通信服务

A机器现在要调用B机器的方法需要传数据给B机器，比如说要调用的函数名，参数。或者A要向B报告A现在的状态，
都需要进行通信，hadoop中使用了protobuf以及thrift传送数据。不基于这个模型可以用RMI或者用CORBA那样的方式，就是架构复杂





