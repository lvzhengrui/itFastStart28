package org.lvzr.fast.nosql.redis.simple;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import org.lvzr.fast.util.Const;
import org.lvzr.fast.util.SerializeUtils;
import org.lvzr.fast.vo.MyVo;

import junit.framework.Assert;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {

	private static JedisPool pool;

	//��̬�����ʼ��������
	static {
		try {
			Properties props = new Properties();
			props.load(RedisTest.class.getClassLoader().getResourceAsStream("redis.properties"));

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

	/**
	 * ���jedis����
	 * @return
	 */
	public static Jedis getJedisObject() {
		return pool.getResource();
	}

	/**
	 * �黹jedis����
	 * @param jedis
	 */
	public static void recycleJedisOjbect(Jedis jedis) {
		pool.returnResource(jedis);
	}

	/**
	 * ����jedis�ط���
	 */
	@Test
	public void MyTest() {
		//���jedisʵ��
		Jedis jedis = getJedisObject();

		//���ַ���
		jedis.set(Const.NAME_KEY, Const.NAME_VALUE);
		//ȡ�ַ���
		Assert.assertEquals(Const.NAME_VALUE, jedis.get(Const.NAME_KEY));
		//ɾ��key
		jedis.del(Const.NAME_KEY);
		//�ж�key�Ƿ����
		Assert.assertFalse(jedis.exists(Const.NAME_KEY));
		
		//�����л�����
		MyVo inputVo = MyVo.getInstance();
		jedis.set(Const.VO_KEY.getBytes(), SerializeUtils.serialize(inputVo));
		//ȡ���л�����
		MyVo outputVo = (MyVo)SerializeUtils.unserizlize(jedis.get(Const.VO_KEY.getBytes()));
		Assert.assertTrue(inputVo.equals(outputVo));
		Assert.assertEquals(Const.NAME_VALUE, outputVo.getName());
		Assert.assertEquals(Const.CITY_VALUE, outputVo.getCity());
 
		//����ȡ��jedisʵ�����󻹻س���
		recycleJedisOjbect(jedis); 
	}
	
	
	

}