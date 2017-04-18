
##Hadoop RPC框架
http://blog.csdn.net/thomas0yang/article/details/41211259




###hadoop源码研读之路（四）----IPC.RPC
http://blog.csdn.net/a15039096218/article/details/7615191

###远程通信的几种选择（RPC，Webservice，RMI，JMS，CORBA的区别）
http://blog.csdn.net/shan9liang/article/details/8995023

###基于RPC原理的dubbo
http://www.cnblogs.com/panxuejun/p/6094790.html



###深入浅出JMS(一)--JMS基本概念
http://blog.csdn.net/jiuqiyuliang/article/details/46701559

###CORBA版HelloWorld
http://lavasoft.blog.51cto.com/62575/240268/



-----------------------------------------------------------------
###Hadoop实现了基于IPC模型的RPC机制

ipc是inter process call，就是进程间通信，可以为进程交换数据服务，rpc是remote process call，
可以为主机间的通信服务

A机器现在要调用B机器的方法需要传数据给B机器，比如说要调用的函数名，参数。或者A要向B报告A现在的状态，
都需要进行通信，hadoop中使用了protobuf以及thrift传送数据。不基于这个模型可以用RMI或者用CORBA那样的方式，就是架构复杂


-----------------------------------------------------
RPC（Remote Procedure Call Protocol），在各大互联网公司中被广泛使用，
如阿里巴巴的hsf、dubbo（开源）、Facebook的thrift（开源）、Google grpc（开源）、Twitter的finagle

目前国内各大互联网公司广泛使用hessian、protobuf、thrift、avro等成熟的序列化解决方案来搭建RPC框架，这些都是久经考验的解决方案。

------------------------------------------------------
如何实现RPC的IO通信框架？
1）使用java nio方式自研，这种方式较为复杂，而且很有可能出现隐藏bug，见过一些互联网公司使用这种方式；
2）基于mina，mina在早几年比较火热，不过这些年版本更新缓慢；
3）基于netty，现在很多RPC框架都直接基于netty这一IO通信框架，比如阿里巴巴的HSF、dubbo，Twitter的finagle等。











