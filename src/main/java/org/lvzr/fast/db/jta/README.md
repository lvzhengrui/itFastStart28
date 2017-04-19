

----------------------------------------------------------------------
###关于分布式事务、两阶段提交、一阶段提交、Best Efforts 1PC模式和事务补偿机制的研究
http://blog.csdn.net/bluishglc/article/details/7612811

之前看多阿里大神程立的一个关于分布式事务的文档，目前使用较多的分布式事务解决方案有几种：
一、结合MQ消息中间件实现的可靠消息最终一致性
二、TCC补偿性事务解决方案
三、最大努力通知型方案

第一种方案：可靠消息最终一致性，需要业务系统结合MQ消息中间件实现，在实现过程中需要保证消息的成功发送及成功消费。
即需要通过业务系统控制MQ的消息状态

第二种方案：TCC补偿性，分为三个阶段TRYING-CONFIRMING-CANCELING。每个阶段做不同的处理。
TRYING阶段主要是对业务系统进行检测及资源预留
CONFIRMING阶段是做业务提交，通过TRYING阶段执行成功后，再执行该阶段。默认如果TRYING阶段执行成功，CONFIRMING就一定能成功。
CANCELING阶段是回对业务做回滚，在TRYING阶段中，如果存在分支事务TRYING失败，则需要调用CANCELING将已预留的资源进行释放。

第三种方案：最大努力通知xing型，这种方案主要用在与第三方系统通讯时，比如：调用微信或支付宝支付后的支付结果通知。这种方案也是结合
MQ进行实现，例如：通过MQ发送http请求，设置最大通知次数。达到通知次数后即不再通知。

具体的案例你也可以参考下这篇博客，它上面的这个案例就是结合电商支付做的系统分布式事务实现
案例：http://www.roncoo.com/article/detail/124243


-----------------------------------------
###Distributed transactions in Spring, with and without XA
http://www.javaworld.com/article/2077963/open-source-tools/distributed-transactions-in-spring--with-and-without-xa.html


-------------------------------------
###微服务架构的分布式事务解决方案
http://www.roncoo.com/article/detail/124243




