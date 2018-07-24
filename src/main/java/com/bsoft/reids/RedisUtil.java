package com.bsoft.reids;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	
	private static String address = "192.168.20.128";
	private static String password = "123456";
	
	private static int port = 6379;
	//连接实例的最大连接数
	private static final int MAX_ACTIVE = 10;
	//控制一个pool最多有多少个状态为idle（空闲）的jedis实例，默认值是8
	private static final int MAX_IDLE = 200;
	//等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException
	private static final int MAX_WAIT = 20000;
	//连接超时时间
	private static final int TIME_OUT = 10000;
	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static final boolean TEST_ON_BORROW = true;
	
	private static JedisPool jedisPool = null;
	
	/**
	 * 初始化redis连接池
	 */
	static{
		
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(MAX_ACTIVE);
		config.setMaxIdle(MAX_IDLE);
		config.setMaxWaitMillis(MAX_WAIT);
		config.setTestOnBorrow(TEST_ON_BORROW);
		jedisPool = new JedisPool(config,address,port,TIME_OUT,password);
		
	}
	
	/**
	 * 
	* @Title: getJedis  
	* @Description: 获得jedis实例
	* @param @return    设定文件  
	* @return Jedis    返回类型  
	* @throws
	 */
	public synchronized static Jedis getJedis(){
		if (jedisPool != null) {
			Jedis jedis = jedisPool.getResource();
			return jedis;
		}
		else {
			return null;
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void releaseResource(final Jedis jedis){
		
		if (jedis != null) {
			jedisPool.returnResource(jedis);
		}
	}

}
