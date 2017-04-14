###在Tomcat配置JNDI数据源的三种方式
http://www.cnblogs.com/xuan52rock/p/4745241.html

###第一种,单个应用独享数据源
就一步,找到Tomcat的server.xml找到工程的Context节点,添加一个私有数据源

<Context docBase="WebApp" path="/WebApp" reloadable="true" source="org.eclipse.jst.jee.server:WebApp">  
<Resource  
    name="jdbc/mysql"   
    scope="Shareable"   
    type="javax.sql.DataSource"  
    factory="org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory"  
    url="jdbc:mysql://localhost:3306/test"  
    driverClassName ="com.mysql.jdbc.Driver"  
    username="root"  
    password="root"  
/>  
</Context>  
优点:简单
缺点:重用性差

###第二种,配置全局JNDI数据源,应用到单个应用
分两步
第一步, 找到Tomcat的server.xml中GlobalNamingResources节点,在节点下加一个全局数据源

<Resource  
    name="jdbc/mysql"   
    scope="Shareable"   
    type="javax.sql.DataSource"  
    factory="org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory"  
    url="jdbc:mysql://localhost:3306/test"  
    driverClassName ="com.mysql.jdbc.Driver"  
    username="root"  
    password="root"  
/>  

第二步,找到要应用此JNDI数据源的工程Context节点,增加对全局数据源的引用ResourceLink 

<Context docBase="WebApp" path="/WebApp" reloadable="true">  
    <ResourceLink global="jdbc/mysql" name="jdbc/mysql" type="javax.sql.DataSource" />  
</Context>  

优点:重用性,可控性

缺点:配置相对第三种方法要繁琐一点,每个工程都得配


###第三种,配置全局JNDI数据源,应用到所有Tomcat下部署的应用
也分两步

第一步

    参考第二种的第一步

第二步,找到Tomcat的***context.xml***,在Context节点下加一个ResourceLink节点对第一步配置的数据源进行引用

这个XML配置文件的根节点就是<Context>

<Context>  
    <ResourceLink global="jdbc/mysql" name="jdbc/mysql" type="javax.sql.DataSource" />  
    <WatchedResource>WEB-INF/web.xml</WatchedResource>  
<Context>  

优点:重用性,一次性到位
缺点:没有可控性





