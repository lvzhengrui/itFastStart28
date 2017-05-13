


###几个主流的Java连接池整理
http://www.cnblogs.com/linjian/p/4831088.html


###Tomcat实现原理详解之手写实现
http://www.toutiao.com/i6357630888234189313/


###电子书
《淘宝技术这十年》
http://download.csdn.net/detail/eastmount/8770187

《架构探险 从零开始写javaweb框架》
http://download.csdn.net/download/laoge/9447089

《大型网站系统与JAVA中间件实践》
http://download.csdn.net/detail/yangle20081982/8863423


###XA分布式事务协议




###阿里的java架构历史
https://wenku.baidu.com/view/c63c606510661ed9ad51f363.html


--------------------------------------------------------------

###ClassLoader类加载机制
p112
p128 funture
p152 分布式事务

#transient
修饰不被序列化的属性

###ConcurrentMap.putIfAbsent(key,value) 用法讨论
http://wxl24life.iteye.com/blog/1746794


###泛型
http://www.cnblogs.com/lzq198754/p/5780426.html
http://blog.csdn.net/yangguanghaozi/article/details/54632477


###Vector
Vector与ArrayList一样，也是通过数组实现的，不同的是它支持线程的同步，即某一时刻只有一个线程能够写Vector，
避免多线程同时写而引起的不一致性，但实现同步需要很高的花费，因此，访问它比访问ArrayList慢。


###使用Java序列化把对象存储到文件中，ObjectOutputStream和ObjectInputStream来进行对象的读取
http://blog.csdn.net/it_wangxiangpan/article/details/5781941


###volatile
一个定义为volatile的变量是说这变量可能会被意想不到地改变，这样，编译器就不会去假设这个变量的值了。精确地说就是，
优化器在用到这个变量时必须每次都小心地重新读取这个变量的值，而不是使用保存在寄存器里的备份


###lvs、haproxy、nginx 负载均衡的比较分析
http://blog.csdn.net/gzh0222/article/details/8540604

###LVS：三种负载均衡方式比较
http://soft.chinabyte.com/25/13169025.shtml


###线程、进程、分布锁


###动态代理、反射、字节码增强asm/cglib


###写给分布式神器fourinone
《大规模分布式系统架构与设计实战》
https://www.oschina.net/question/923302_153907

---------------------------------------------------------------------------
###Apache Commons是一个非常有用的工具包
解决各种实际的通用问题，下面是一个简述表，
详细信息访问http://jakarta.apache.org/commons/index.html

BeanUtils
Commons-BeanUtils 提供对 Java 反射和自省API的包装

Betwixt
Betwixt提供将 JavaBean 映射至 XML 文档，以及相反映射的服务.

Chain
Chain 提供实现组织复杂的处理流程的“责任链模式”.

CLI
CLI 提供针对命令行参数，选项，选项组，强制选项等的简单API.

Codec
Codec 包含一些通用的编码解码算法。包括一些语音编码器， Hex, Base64, 以及URL encoder.

Collections
Commons-Collections 提供一个类包来扩展和增加标准的 Java Collection框架

Configuration
Commons-Configuration 工具对各种各式的配置和参考文件提供读取帮助.

Daemon
一种 unix-daemon-like java 代码的替代机制

DBCP
Commons-DBCP 提供数据库连接池服务

DbUtils
DbUtils 是一个 JDBC helper 类库，完成数据库任务的简单的资源清除代码.

Digester
Commons-Digester 是一个 XML-Java对象的映射工具，用于解析 XML配置文件.

Discovery
Commons-Discovery 提供工具来定位资源 (包括类) ，通过使用各种模式来映射服务/引用名称和资源名称。.

EL
Commons-EL 提供在JSP2.0规范中定义的EL表达式的解释器.

FileUpload
FileUpload 使得在你可以在应用和Servlet中容易的加入强大和高性能的文件上传能力

HttpClient
Commons-HttpClient 提供了可以工作于HTTP协议客户端的一个框架.

IO
IO 是一个 I/O 工具集

Jelly
Jelly是一个基于 XML 的脚本和处理引擎。 Jelly 借鉴了 JSP 定指标签，Velocity, Cocoon和Xdoclet中的脚本引擎的许多优点。Jelly 可以用在命令行， Ant 或者 Servlet之中。

Jexl
Jexl是一个表达式语言，通过借鉴来自于Velocity的经验扩展了JSTL定义的表达式语言。.

JXPath
Commons-JXPath 提供了使用Xpath语法操纵符合Java类命名规范的 JavaBeans的工具。也支持 maps, DOM 和其他对象模型。.

Lang
Commons-Lang 提供了许多许多通用的工具类集，提供了一些java.lang中类的扩展功能

Latka
Commons-Latka 是一个HTTP 功能测试包，用于自动化的QA,验收和衰减测试.

Launcher
Launcher 组件是一个交叉平台的Java 应用载入器。 Commons-launcher 消除了需要批处理或者Shell脚本来载入Java 类。.原始的 Java 类来自于Jakarta Tomcat 4.0 项目

Logging
Commons-Logging 是一个各种 logging API实现的包裹类.

Math
Math 是一个轻量的，自包含的数学和统计组件，解决了许多非常通用但没有及时出现在Java标准语言中的实践问题.

Modeler
Commons-Modeler 提供了建模兼容JMX规范的 Mbean的机制.

Net
Net 是一个网络工具集，基于 NetComponents 代码，包括 FTP 客户端等等。

Pool
Commons-Pool 提供了通用对象池接口，一个用于创建模块化对象池的工具包，以及通常的对象池实现.

Primitives
Commons-Primitives提供了一个更小，更快和更易使用的对Java基本类型的支持。当前主要是针对基本类型的 collection。.

Validator
The commons-validator提供了一个简单的，可扩展的框架来在一个XML文件中定义校验器 (校验方法)和校验规则。支持校验规则的和错误消息的国际化。


-------------------------------------------------
###Jakarta项目
是在Apache软件基金会营运的公开源代码软件开发项目之一。开发着面向编程语言Java的程序库，框架等。

Jakarta是Apache组织下的一套Java解决方案的开源软件的名称，它包括了很多子项目。Tomcat、Ant、Struts等等现在是Apache下的开源项目，
也曾是Jakarta的关联项目。

Jakarta的名称是想把与Jakarta关系非常深的爪哇岛关联起来。编程语言Java的命名源自这个岛的名字Jawa，而城市雅加达(Jakarta)正是这
个岛上的第一大城市，也是印度尼西亚的首府。

子项目
其中，雅加达项目所包括的相关工具、库以及框架等罗列如下:

BCEL - 处理Java字节码的类库
BSF - 脚本程序框架
Cactus - 服务器端Java类测试工具框架
ECS - The Element Construction Set is a Java API for generating elements for various markup anguages.
HttpComponents- The Hyper-Text Transfer Protocol.
JCS - JCS is a distributed caching system written in java.
JMeter - 压力测试工具
ORO - Java classes that provide Perl5 compatible regular expressions.
Regexp - 纯Java正则表达式包
Slide - a content repository primarily using WebDAV.
Taglibs - Repository for JSP custom tag libraries.

以前隶属于雅加达项目，但现在作为Aapche软件基金的单独项目，有:
Ant - 构建工具
Commons - 一组使用类的合集，主要作为Java标准库的补充
HiveMind - a services and configuration microkernel
Maven - a project build and management tool
POI - a pure Java port of Microsoft's popular file formats.
Struts - a web application development framework
Tapestry - A component object model based on JavaBeans properties and strong specifications
Tomcat - 服务器，提供JSP/Servlet相关容器类
Turbine - a rapid development web application framework
Velocity - a template engine

--------------------------------------------------------------------------------
###20条老鸟程序员才知道的小技巧
1.学习一门新技术时，多看并且认真看官方文档！！翻译官方文档是通向“业界大拿”的捷径。
2.经常写工作日志，能提升脑容量。
3.注释贵精不贵多，杜绝大姨妈般的“例注”，流水账式的注释实际就是噪音。
4.经常google，普通程序员+google=超级程序员。
5.推荐一本技术书：《逻辑学导论》。
6.常充电。程序员只有一种死法：土死的。
7.最好的工具是纸笔;其次是OneNote。
8.重构/优化/修复Bug，同时只能作一件。
9,简单模块注意封装，复杂模块注意分层。不好用的接口尝试用封装。
10.编码的时候只思考同一个思维层次的逻辑，在这层完成之后再思考下一层。
11.不要先写框架再写实现。最好反过来，从原型中提炼框架。
12.宁可多算一周，不可少估一天。过于“乐观”容易让boss受惊吓。
13.不要定过大、过远、过细的计划。即使定了也没有用。
14.把觉得不靠谱的需求放到最后做。很可能到时候需求就变了。
15.与主流意见/方法/风格/习惯相悖时，先检讨自己最可靠。
16.出现bug主动查，不管是不是你的。这能让你业务能力猛涨、个人形象飙升; 如果你的bug被别人揪出来.....呵呵，那你会很被动～≧﹏≦
17.需要解决比较复杂数学问题的时候，请直接找数学专业人士，而不是自己跳坑。
18.造轮子是很好的锻炼方法。前提是你见过别的轮子。
19.提问前先做调研。问不到点上既被鄙视，又浪费自己的时间。




