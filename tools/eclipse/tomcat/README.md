

eclipse配置项目部署到到本地tomcat

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
④打开tomcat的修改界面(open)
⑤找到servers location，选择第二个(User tomcat Installation) 
⑥修改deploy path为webapps 
⑦保存关闭

需要说明的是①②③必须操作，否则下面的步骤会被置灰无法操作。




