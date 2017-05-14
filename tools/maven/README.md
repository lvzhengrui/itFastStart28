
###Maven学习 (四) 使用Nexus搭建Maven私服
http://www.cnblogs.com/quanyongan/archive/2013/04/24/3037589.html
http://www.sonatype.org/nexus/go/下载nexus-2.14.4-03
nexus-2.14.4-03-bundle\nexus-2.14.4-03\bin\jsw\windows-x86-64\console-nexus.bat启动服务器
默认的用户名是 admin 密码是 admin123
界面登录http://127.0.0.1:8081/nexus/ 

C:\Users\${loginName}\.m2\settings.xml配置如下：
<mirror>
    <id>localMaven</id>
    <mirrorOf>*</mirrorOf>
    <name>privateServer</name>
  <url>http://127.0.0.1:8081/nexus/content/groups/public/</url>
</mirror>
    

###nuex设置方式    
http://blog.csdn.net/mexican_jacky/article/details/50275695

###修改mvn jdk
settings.xml里修改profile节点jdk版本号，然eclipse下update maven



###使用maven生成可执行的jar包
http://www.cnblogs.com/justinzhang/p/4975727.html

###使用Maven Assembly plugin将依赖打包进jar
http://www.cnblogs.com/justinzhang/p/4983633.html



