###��Tomcat����JNDI����Դ�����ַ�ʽ
http://www.cnblogs.com/xuan52rock/p/4745241.html

###��һ��,����Ӧ�ö�������Դ
��һ��,�ҵ�Tomcat��server.xml�ҵ����̵�Context�ڵ�,���һ��˽������Դ

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
�ŵ�:��
ȱ��:�����Բ�

###�ڶ���,����ȫ��JNDI����Դ,Ӧ�õ�����Ӧ��
������
��һ��, �ҵ�Tomcat��server.xml��GlobalNamingResources�ڵ�,�ڽڵ��¼�һ��ȫ������Դ

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

�ڶ���,�ҵ�ҪӦ�ô�JNDI����Դ�Ĺ���Context�ڵ�,���Ӷ�ȫ������Դ������ResourceLink 

<Context docBase="WebApp" path="/WebApp" reloadable="true">  
    <ResourceLink global="jdbc/mysql" name="jdbc/mysql" type="javax.sql.DataSource" />  
</Context>  

�ŵ�:������,�ɿ���

ȱ��:������Ե����ַ���Ҫ����һ��,ÿ�����̶�����


###������,����ȫ��JNDI����Դ,Ӧ�õ�����Tomcat�²����Ӧ��
Ҳ������

��һ��

    �ο��ڶ��ֵĵ�һ��

�ڶ���,�ҵ�Tomcat��***context.xml***,��Context�ڵ��¼�һ��ResourceLink�ڵ�Ե�һ�����õ�����Դ��������

���XML�����ļ��ĸ��ڵ����<Context>

<Context>  
    <ResourceLink global="jdbc/mysql" name="jdbc/mysql" type="javax.sql.DataSource" />  
    <WatchedResource>WEB-INF/web.xml</WatchedResource>  
<Context>  

�ŵ�:������,һ���Ե�λ
ȱ��:û�пɿ���





