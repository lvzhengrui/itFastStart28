package org.lvzr.fast.nosql.memcached;

import com.danga.MemCached.MemCachedClient;  
import com.danga.MemCached.SockIOPool;  
  
public class CacheHelper {  
      
    /* ����ģʽ */  
    protected static MemCachedClient mcc = new MemCachedClient();  
      
    private CacheHelper() {  
    }  
      
    /* ���÷������� */  
    static {  
          
        /* ����IP��ַ�Ͷ˿� */  
        String[] servers = { "127.0.0.1:11212" };  
          
        /* ���û����С */  
        Integer[] weights = { 2 };  
          
        /* �õ�һ�����ӳص�ʵ�� */  
        SockIOPool pool = SockIOPool.getInstance();  
          
        /* ע�����������Ϣ */  
        pool.setServers(servers);  
        pool.setWeights(weights);  
          
        /* ���û���ص�һЩ������Ϣ */  
        pool.setInitConn(5);  
        pool.setMinConn(5);  
        pool.setMaxConn(250);  
        pool.setMaxIdle(1000 * 60 * 60 * 6);  
          
        /* �����߳�����ʱ�� */  
        pool.setMaintSleep(30);  
          
        /* ���ù���TCP���� */  
        pool.setNagle(false);// ����nagle�㷨  
        pool.setSocketConnectTO(0);  
        pool.setSocketTO(3000);// 3�볬ʱ  
          
        /* ��ʼ�� */  
        pool.initialize();  
          
        /* ���û���ѹ�� */  
        mcc.setCompressEnable(true);  
        mcc.setCompressThreshold(64 * 1024);  
          
    }  
      
    public static boolean set(String arg0, Object arg1) {  
        return mcc.set(arg0, arg1);  
    }  
      
    public static Object get(String arg0) {  
        return mcc.get(arg0);  
    }  
      
    /* ���� */  
    public static void main(String[] args) {  
        CacheHelper.set("gogo", "gogogogo");  
        System.out.println(CacheHelper.get("gogo"));// gogogogo  
        System.out.println(CacheHelper.get("gogog"));// null  
        /* ������ֶ�Ϊnull������ַ�Ͷ˿ڡ��˿ڿ��Ե�MemcachedͬĿ¼�����ļ��� */  
    }  
      
}  
 