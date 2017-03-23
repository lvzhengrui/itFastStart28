package org.lvzr.fast.java.patten.struct.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 *12����Ԫģʽ��Flyweight��
   ��Ԫģʽ����ҪĿ����ʵ�ֶ���Ĺ���������أ���ϵͳ�ж�����ʱ����Լ����ڴ�Ŀ�����ͨ���빤��ģʽһ��ʹ�á�
 FlyWeightFactory���𴴽��͹�����Ԫ��Ԫ����һ���ͻ�������ʱ��������Ҫ��鵱ǰ��������Ƿ��з��������Ķ���
  ����У��ͷ����Ѿ����ڵĶ������û�У��򴴽�һ���¶���FlyWeight�ǳ��ࡣһ�ᵽ����أ����Ǻ��������뵽Java
  �����JDBC���ӳأ�����ÿ�����ӵ��ص㣬���ǲ����ܽ�����������������һЩ������������һЩ���е����ԣ�
  �������ݿ����ӳ���˵��url��driverClassName��username��password��dbname����Щ���Զ���ÿ��������˵����һ���ģ�
  ���Ծ��ʺ�����Ԫģʽ��������һ�������࣬����������������Ϊ�ڲ����ݣ���������Ϊ�ⲿ���ݣ��ڷ�������ʱ��
  ���������������������ͽ�ʡ�˿ռ䣬������ʵ����������
 *
 */
public class ConnectionPool {  
    
	private int poolSize = 100;  
	private int poolIndex = 0;
    private Vector<Connection> pool;  
 
    /*��������*/  
    private String url = "jdbc:mysql://localhost:3306/test";  
    private String username = "root";  
    private String password = "root";  
    private String driverClassName = "com.mysql.jdbc.Driver";  
  
    
    /*���췽������һЩ��ʼ������*/  
    private ConnectionPool() {  
        pool = new Vector<Connection>(poolSize);  
        for (int i = 0; i < poolSize; i++) {  
            try {  
                Class.forName(driverClassName);  
                Connection conn = DriverManager.getConnection(url, username, password);  
                pool.add(conn);  
            } catch (ClassNotFoundException e) {  
                e.printStackTrace();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    /* �������ӵ����ӳ� */  
    public synchronized void release() {  
    	if(poolIndex>0){
    		poolIndex--;
    	}
    }  
  
    /* �������ӳ��е�һ�����ݿ����� */  
    public synchronized Connection getConnection() {  
        if (poolIndex<poolSize) {  
            Connection conn = pool.get(poolIndex);  
            poolIndex ++;
            return conn;
        } else {  
            return null;  
        }  
    }  
    
}  

