
###eclipse4.6 tomcat�����ַ
http://download.csdn.net/detail/qq_36731677/9756375
http://blog.csdn.net/qq_36731677/article/details/55308457?locationNum=13&fps=1

 
###eclipse������Ŀ���𵽵�����tomcat(��������Ŀ)

һ����������
��eclipse���½�Dynamic Web Project�����úñ��ص�tomcat��д�ô����ѡ��Run on Server,�����к�����tomcat�İ�
װĿ¼�µ�webapps��û�г����������Ĺ������֡�

������֤
��������Ŀ��û���Զ�����Tomcat��Webapps�ж��ǲ������˱�������С������������������http://localhost:8080/webDemo/login.jsp������
�򿪡������ⲿ������ϴ�http://localhost:8080ʱȷû�г�����������Сè���档

����ԭ��
eclipse����MyEclipseĬ�Ͻ���Ŀ����tomcat��װĿ¼�µ�webapps�У���Ĭ�ϲ��𵽹���Ŀ¼��
��.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps�У�tmp1�ļ����������Ÿ���Ŀ����Ϣ��


�ġ��޸�
Ϊ��ʹ��ĿĬ�ϲ���tomcat��װĿ¼�µ�webapps�У�show view��>servers��>�ҵ���Ҫ�޸ĵ�tomcat��>�һ� 

��ֹͣeclipse�ڵ�Tomcat������(stop) 
��ɾ���������в������Ŀ(add and remove) 
������������������(clean) 
��***��tomcat���޸Ľ���(open)���������������Ŀʱ����module����Context��****
���ҵ�servers location��ѡ��ڶ���(User tomcat Installation) 
���޸�deploy pathΪwebapps 
�߱���ر�



��Ҫ˵�����Ǣ٢ڢ۱����������������Ĳ���ᱻ�û��޷�������



--------------------------------------------------------
##tomcat context.xml����
http://blog.csdn.net/heqingsong1/article/details/8539163

###1. ��tomcat 5.5֮ǰ��
Context������/conf/server.xml�е�Host���<Context>Ԫ�أ�����Context�ӿڶ��塣ÿ��<ContextԪ�ش��������������������ϵĵ���WebӦ��

[html] view plain copy
<Context path="/kaka" docBase="kaka" debug="0" reloadbale="true">   
	<ResourceLink global="jdbc/RONE4" name="jdbc/RONE4" type="javax.sql.DataSource"/> 
</Context>

1>path����Ҫ����������Ŀ¼��,ע����/kaka����ָ������WebӦ�õ�URL��ڣ���http://localhost:8080/kaka/****
2>docBase��Ϊʵ��Ŀ¼��Ӳ���ϵ�λ�ã�Ӧ�ó����·��������WAR�ļ���ŵ�·����
3>reloadable��������������Ϊtrue��Tomcat������������״̬�»������WEB-INF/classes��Web-INF/libĿ¼CLASS�ļ��ĸı䣬
������ӵ���class�ļ������£��������Զ����¼���WebӦ�ã��������ǿ����ڲ�����tomcat������¸ı�Ӧ�ó���

һ��HostԪ����Ƕ��������ContextԪ�ء�ÿ��Context��·��������Ωһ�ģ���path���Զ��塣���⣬����붨��һ��path=������context��
���Context��Ϊ������������ȱʡwebӦ�ã�����������Щ����ƥ���κ�Context��Context·��������

4>ResourceLink��Ӧ������Դ���ã���������GlobalNamingResources������Ӧ������Դ



###2. ��tomcat 5.5֮��

���Ƽ���server.xml�н������ã�������/conf/context.xml�н��ж��������á���Ϊserver.xml�ǲ��ɶ�̬�ؼ��ص���Դ��������һ��
�������Ժ�Ҫ�޸�����ļ����͵������������������¼��ء���context.xml�ļ���Ȼ��tomcat�������ᶨʱȥɨ������ļ���һ����
���ļ����޸ģ�ʱ����ı��ˣ����ͻ��Զ����¼�������ļ���������Ҫ������������

<Context path="/kaka" docBase="kaka" debug="0" reloadbale="true" privileged="true">  
	<WatchedResource>WEB-INF/web.xml</WatchedResource>  
  
	<WatchedResource>WEB-INF/kaka.xml</WatchedResource> �����Դ�ļ������web.xml || kaka.xml�ı��ˣ����Զ����¼��ظ�Ӧ�á�  
	  
	<Resource name="jdbc/testSiteds" ��ʾָ����jndi����  
		auth="Container" ��ʾ��֤��ʽ��һ��ΪContainer  
		type="javax.sql.DataSource"  
		maxActive="100" ���ӳ�֧�ֵ����������  
		maxIdle="30" ���ӳ������ɿ���maxIdle������  
		maxWait="10000" ���ӳ�����������ʱ,�µ�����ȴ�ʱ��,����  
		username="root" ��ʾ���ݿ��û���  
		password="root" ��ʾ���ݿ��û�������  
		driverClassName="com.mysql.jdbc.Driver" ��ʾJDBC DRIVER  
		url="jdbc:mysql://localhost:3306/testSite" /> ��ʾ���ݿ�URL��ַ  
</Context>  

##��context.xml���������÷�Χ��

1. tomcat server����
	��/conf/context.xml������

2. Host����
	��/conf/Catalina/${hostName}�����context.xml���̶���������

3. web app ����
	��/conf/Catalina/${hostName}�����${webAppName}.xml���̶���������

tomcat�е�server.xmlԪ������server.xml.jpg



----------------------------------------
###mysql����Դ
<Resource name="jdbc/mysql_c3p0" scope="Shareable"  
    type="com.mchange.v2.c3p0.ComboPooledDataSource"   
    factory="org.apache.naming.factory.BeanFactory"  
    jdbcUrl="jdbc:mysql://localhost:3306/test" driverClass="com.mysql.jdbc.Driver"  
    user="root" password="root" />  
    
    
    

    
    
    
    