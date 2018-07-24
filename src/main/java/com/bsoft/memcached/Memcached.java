package com.bsoft.memcached;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * Hello world!
 *
 */
public class Memcached {
	private static MemCachedClient cachedClient = new MemCachedClient();

	static {
		// 获取连接池的实例
		SockIOPool pool = SockIOPool.getInstance();
		// 服务器列表及权重
		String[] servers = { "192.168.1.75:11211","192.168.1.75:9999"};
		Integer[] weights = { 3,4};
		// 设置服务器信息
		pool.setServers(servers);
		pool.setWeights(weights);
		// 设置初始连接数，最小连接数，最大连接数，最大处理时间
		pool.setInitConn(10);
		pool.setMinConn(10);
		pool.setMaxConn(1000);
		pool.setMaxIdle(1000 * 60 * 60);
		// 设置主线程睡眠时间，每3秒苏醒一次，维持连接池大小
		// maintSleep 千万不要设置成30，访问量一大就出问题，单位是毫秒，推荐30000毫秒。
		pool.setMaintSleep(30000);
		// 关闭套接字缓存
		pool.setNagle(false);
		pool.setSocketTO(3000);
		pool.setSocketConnectTO(0);
		// 初始化并启动连接池
		pool.initialize();

	}

	public static boolean add(String key, Object value) {
		return cachedClient.add(key, value);
	}

	/**
	 * 新增缓存数据,该KEY值如果没有则插入
	 * 
	 * @param key
	 *            键（key）
	 * @param value
	 * @param expire
	 *            过期时间（单位是秒）
	 * 
	 * @return
	 */
	public static boolean add(String key, Object value, Integer expire) {
		return cachedClient.add(key, value, expire);
	}

	public static boolean add(String key, Object value, Date expireDate) {
		return cachedClient.add(key, value, expireDate);
	}

	public static boolean set(String key, Object value) {
		return cachedClient.set(key, value);
	}

	/**
	 * 设置缓存中的对象（value），如果没有则插入，如果有则修改。
	 * 
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 */
	public static boolean set(String key, Object value, Integer expire) {
		return cachedClient.set(key, value, expire);
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @param expireDate
	 *            失效日期
	 * @return
	 */
	public static boolean set(String key, Object value, Date expireDate) {
		return cachedClient.set(key, value, expireDate);
	}

	public static boolean replace(String key, Object value) {
		return cachedClient.replace(key, value);
	}

	/**
	 * 该键的新值（new value），如果有则修改。
	 * 
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 */
	public static boolean replace(String key, Object value, Integer expire) {
		return cachedClient.replace(key, value, expire);
	}

	public static boolean replace(String key, Object value, Date expireDate) {
		return cachedClient.replace(key, value, expireDate);
	}

	public static Object get(String key) {
		return cachedClient.get(key);
	}
	
	public static boolean delete(String key){
		return cachedClient.delete(key);
	}

	/**
	 * 清空所有对象
	 */
	public static void flushAll() {
		cachedClient.flushAll();
	}

	public static void main(String[] args) {

		//JavaToMemcached.set("mem", "12e3232", 60);
		//JavaToMemcached.set("mem1", "mem1mem1");
		/*Date date = new Date(4000);
		JavaToMemcached.set("mem", "12e3232", date);*/
		//JavaToMemcached.delete("mem");
		
		//Memcached.set("dc","111");
		//Memcached.add("dd", "2222",30);
		
		Date date = new Date(60000);
		System.out.println(date);
		Memcached.add("ff", "11111", date);
		
		System.out.println(Memcached.get("ff"));
	}

}
