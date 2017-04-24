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

	//静态代码初始化池配置
	static {
		try {
			Properties props = new Properties();
			props.load(RedisTest.class.getClassLoader().getResourceAsStream("redis.properties"));

			//创建jedis池配置实例
			JedisPoolConfig config = new JedisPoolConfig();

			//设置池配置项值
			//config.setMaxActive(Integer.valueOf(props.getProperty("jedis.pool.maxActive")));
			config.setMaxIdle(Integer.valueOf(props.getProperty("jedis.pool.maxIdle")));
			//config.setMaxWait(Long.valueOf(props.getProperty("jedis.pool.maxWait")));
			config.setTestOnBorrow(Boolean.valueOf(props.getProperty("jedis.pool.testOnBorrow")));
			config.setTestOnReturn(Boolean.valueOf(props.getProperty("jedis.pool.testOnReturn")));
			
			//根据配置实例化jedis池
			pool = new JedisPool(config, props.getProperty("redis.ip"),
					Integer.valueOf(props.getProperty("redis.port")));
			
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	/**
	 * 获得jedis对象
	 * @return
	 */
	public static Jedis getJedisObject() {
		return pool.getResource();
	}

	/**
	 * 归还jedis对象
	 * @param jedis
	 */
	public static void recycleJedisOjbect(Jedis jedis) {
		pool.returnResource(jedis);
	}

	/**
	 * 测试jedis池方法
	 */
	@Test
	public void MyTest() {
		//获得jedis实例
		Jedis jedis = getJedisObject();

		//存字符串
		jedis.set(Const.NAME_KEY, Const.NAME_VALUE);
		//取字符串
		Assert.assertEquals(Const.NAME_VALUE, jedis.get(Const.NAME_KEY));
		//删除key
		jedis.del(Const.NAME_KEY);
		//判断key是否存在
		Assert.assertFalse(jedis.exists(Const.NAME_KEY));
		
		//存序列化对象
		MyVo inputVo = MyVo.getInstance();
		jedis.set(Const.VO_KEY.getBytes(), SerializeUtils.serialize(inputVo));
		//取序列化对象
		MyVo outputVo = (MyVo)SerializeUtils.unserizlize(jedis.get(Const.VO_KEY.getBytes()));
		Assert.assertTrue(inputVo.equals(outputVo));
		Assert.assertEquals(Const.NAME_VALUE, outputVo.getName());
		Assert.assertEquals(Const.CITY_VALUE, outputVo.getCity());
 
		//将获取的jedis实例对象还回迟中
		recycleJedisOjbect(jedis); 
	}
	
	
	

}