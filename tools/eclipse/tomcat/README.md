
###eclipse4.6 tomcat插件地址
http://download.csdn.net/detail/qq_36731677/9756375
http://blog.csdn.net/qq_36731677/article/details/55308457?locationNum=13&fps=1

 
###eclipse配置项目部署到到本地tomcat(部署多个项目)

一、发现问题
在eclipse中新建Dynamic Web Project，配置好本地的tomcat并写好代码后选择Run on Server,但运行后发现在tomcat的安
装目录下的webapps并没有出现所建立的工程名字。

二、验证
很明显项目并没有自动部署到Tomcat的Webapps中而是部署在了别的容器中。在内置浏览器中输入http://localhost:8080/webDemo/login.jsp可正常
打开。但在外部浏览器上打开http://localhost:8080时确没有出现所期望的小猫画面。

三、原因
eclipse不像MyEclipse默认将项目部署到tomcat安装目录下的webapps中，而默认部署到工作目录下
的.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps中，tmp1文件夹里面存放着该项目的信息。


四、修改
为了使项目默认部署到tomcat安装目录下的webapps中，show view—>servers—>找到需要修改的tomcat—>右击 

①停止eclipse内的Tomcat服务器(stop) 
②删除该容器中部署的项目(add and remove) 
③清除该容器相关数据(clean) 
④***打开tomcat的修改界面(open)，配置启动多个项目时，在module配置Context包****
⑤找到servers location，选择第二个(User tomcat Installation) 
⑥修改deploy path为webapps 
⑦保存关闭



需要说明的是①②③必须操作，否则下面的步骤会被置灰无法操作。



--------------------------------------------------------
##tomcat context.xml配置
http://blog.csdn.net/heqingsong1/article/details/8539163

###1. 在tomcat 5.5之前：
Context体现在/conf/server.xml中的Host里的<Context>元素，它由Context接口定义。每个<Context元素代表了运行在虚拟主机上的单个Web应用

[html] view plain copy
<Context path="/kaka" docBase="kaka" debug="0" reloadbale="true">   
	<ResourceLink global="jdbc/RONE4" name="jdbc/RONE4" type="javax.sql.DataSource"/> 
</Context>

1>path：即要建立的虚拟目录，,注意是/kaka，它指定访问Web应用的URL入口，如http://localhost:8080/kaka/****
2>docBase：为实际目录在硬盘上的位置（应用程序的路径或者是WAR文件存放的路径）
3>reloadable：如果这个属性设为true，Tomcat服务器在运行状态下会监视在WEB-INF/classes和Web-INF/lib目录CLASS文件的改变，
如果监视到有class文件被更新，服务器自动重新加载Web应用，这样我们可以在不重起tomcat的情况下改变应用程序

一个Host元素中嵌套任意多的Context元素。每个Context的路径必须是惟一的，由path属性定义。另外，你必须定义一个path=“”的context，
这个Context称为该虚拟主机的缺省web应用，用来处理那些不能匹配任何Context的Context路径的请求。

4>ResourceLink对应的数据源配置，必须先在GlobalNamingResources配置相应的数据源



###2. 在tomcat 5.5之后：

不推荐在server.xml中进行配置，而是在/conf/context.xml中进行独立的配置。因为server.xml是不可动态重加载的资源，服务器一旦
启动了以后，要修改这个文件，就得重启服务器才能重新加载。而context.xml文件则不然，tomcat服务器会定时去扫描这个文件。一旦发
现文件被修改（时间戳改变了），就会自动重新加载这个文件，而不需要重启服务器。

<Context path="/kaka" docBase="kaka" debug="0" reloadbale="true" privileged="true">  
	<WatchedResource>WEB-INF/web.xml</WatchedResource>  
  
	<WatchedResource>WEB-INF/kaka.xml</WatchedResource> 监控资源文件，如果web.xml || kaka.xml改变了，则自动重新加载改应用。  
	  
	<Resource name="jdbc/testSiteds" 表示指定的jndi名称  
		auth="Container" 表示认证方式，一般为Container  
		type="javax.sql.DataSource"  
		maxActive="100" 连接池支持的最大连接数  
		maxIdle="30" 连接池中最多可空闲maxIdle个连接  
		maxWait="10000" 连接池中连接用完时,新的请求等待时间,毫秒  
		username="root" 表示数据库用户名  
		password="root" 表示数据库用户的密码  
		driverClassName="com.mysql.jdbc.Driver" 表示JDBC DRIVER  
		url="jdbc:mysql://localhost:3306/testSite" /> 表示数据库URL地址  
</Context>  

##附context.xml的三个作用范围：

1. tomcat server级别：
	在/conf/context.xml里配置

2. Host级别：
	在/conf/Catalina/${hostName}里添加context.xml，继而进行配置

3. web app 级别：
	在/conf/Catalina/${hostName}里添加${webAppName}.xml，继而进行配置

tomcat中的server.xml元素详解见server.xml.jpg



----------------------------------------
###mysql数据源
<Resource name="jdbc/mysql_c3p0" scope="Shareable"  
    type="com.mchange.v2.c3p0.ComboPooledDataSource"   
    factory="org.apache.naming.factory.BeanFactory"  
    jdbcUrl="jdbc:mysql://localhost:3306/test" driverClass="com.mysql.jdbc.Driver"  
    user="root" password="root" />  
    
    
    

    
    
    
    