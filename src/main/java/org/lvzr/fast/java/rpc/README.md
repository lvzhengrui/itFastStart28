
##Hadoop RPC���
http://blog.csdn.net/thomas0yang/article/details/41211259




###hadoopԴ���ж�֮·���ģ�----IPC.RPC
http://blog.csdn.net/a15039096218/article/details/7615191

###Զ��ͨ�ŵļ���ѡ��RPC��Webservice��RMI��JMS��CORBA������
http://blog.csdn.net/shan9liang/article/details/8995023

###����RPCԭ���dubbo
http://www.cnblogs.com/panxuejun/p/6094790.html



###����ǳ��JMS(һ)--JMS��������
http://blog.csdn.net/jiuqiyuliang/article/details/46701559

###CORBA��HelloWorld
http://lavasoft.blog.51cto.com/62575/240268/



-----------------------------------------------------------------
###Hadoopʵ���˻���IPCģ�͵�RPC����

ipc��inter process call�����ǽ��̼�ͨ�ţ�����Ϊ���̽������ݷ���rpc��remote process call��
����Ϊ�������ͨ�ŷ���

A��������Ҫ����B�����ķ�����Ҫ�����ݸ�B����������˵Ҫ���õĺ�����������������AҪ��B����A���ڵ�״̬��
����Ҫ����ͨ�ţ�hadoop��ʹ����protobuf�Լ�thrift�������ݡ����������ģ�Ϳ�����RMI������CORBA�����ķ�ʽ�����Ǽܹ�����


-----------------------------------------------------
RPC��Remote Procedure Call Protocol�����ڸ���������˾�б��㷺ʹ�ã�
�簢��Ͱ͵�hsf��dubbo����Դ����Facebook��thrift����Դ����Google grpc����Դ����Twitter��finagle

Ŀǰ���ڸ���������˾�㷺ʹ��hessian��protobuf��thrift��avro�ȳ�������л�����������RPC��ܣ���Щ���Ǿþ�����Ľ��������

------------------------------------------------------
���ʵ��RPC��IOͨ�ſ�ܣ�
1��ʹ��java nio��ʽ���У����ַ�ʽ��Ϊ���ӣ����Һ��п��ܳ�������bug������һЩ��������˾ʹ�����ַ�ʽ��
2������mina��mina���缸��Ƚϻ��ȣ�������Щ��汾���»�����
3������netty�����ںܶ�RPC��ܶ�ֱ�ӻ���netty��һIOͨ�ſ�ܣ����簢��Ͱ͵�HSF��dubbo��Twitter��finagle�ȡ�











