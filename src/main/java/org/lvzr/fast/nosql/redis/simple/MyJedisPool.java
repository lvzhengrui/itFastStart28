package org.lvzr.fast.nosql.redis.simple;

import java.io.IOException;
import java.util.Properties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class MyJedisPool {

	private static JedisPool pool;

	//��̬�����ʼ��������
	static {
		try {
			Properties props = new Properties();
			props.load(MyJedisPool.class.getClassLoader().getResourceAsStream("MyJedisPool.properties"));

			//����jedis������ʵ��
			JedisPoolConfig config = new JedisPoolConfig();

			//���ó�������ֵ
			//config.setMaxActive(Integer.valueOf(props.getProperty("jedis.pool.maxActive")));
			config.setMaxIdle(Integer.valueOf(props.getProperty("jedis.pool.maxIdle")));
			//config.setMaxWait(Long.valueOf(props.getProperty("jedis.pool.maxWait")));
			config.setTestOnBorrow(Boolean.valueOf(props.getProperty("jedis.pool.testOnBorrow")));
			config.setTestOnReturn(Boolean.valueOf(props.getProperty("jedis.pool.testOnReturn")));
			
			//��������ʵ����jedis��
			pool = new JedisPool(config, props.getProperty("redis.ip"),
					Integer.valueOf(props.getProperty("redis.port")));
			
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	/** ���jedis���� */
	public static Jedis getJedisObject() {
		return pool.getResource();
	}

	/** �黹jedis���� */
	public static void recycleJedisOjbect(Jedis jedis) {
		pool.returnResource(jedis);
	}

	/**
	 * ����jedis�ط���
	 */
	public static void main(String[] args) {

		Jedis jedis = getJedisObject();// ���jedisʵ��

		//��ȡjedisʵ������Զ�redis�������һϵ�еĲ���
		jedis.set("name", "zhuxun");
		System.out.println(jedis.get("name"));

		jedis.del("name");
		System.out.println(jedis.exists("name"));

		recycleJedisOjbect(jedis); // ����ȡ��jedisʵ�����󻹻س���

	}

}