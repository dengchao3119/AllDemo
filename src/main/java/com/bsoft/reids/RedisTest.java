package com.bsoft.reids;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class RedisTest {

	
	private Jedis jedis;
	
	/**
	 * 
	* @Title: connectRedis  
	* @Description: 连接redis服务器  
	* @param     设定文件  
	* @return void    返回类型  
	* @throws
	 */
	public void connectRedis(){
		jedis =RedisUtil.getJedis();
	}
	
	/**
	 * 
	* @Title: testString  
	* @Description: redis操作字符串
	* @param     设定文件  
	* @return void    返回类型  
	* @throws
	 */
	public void testString(){
		//添加数据
		jedis.set("aa", "dengchao");
		System.err.println(jedis.get("aa"));
		
		//追加数据
		jedis.append("aa","shacha");
		System.out.println(jedis.get("aa"));
		//删除数据
		jedis.del("aa");
		System.out.println(jedis.get("aa"));
		
		jedis.mset("aa","dengchao","age","27","tel","18271261013");
		jedis.incr("age");
		System.out.println(jedis.get("aa")+"-"+jedis.get("age")+"-"+jedis.get("tel"));
		
	}
	
	/**
	 * 
	* @Title: testMap  
	* @Description: 操作hash
	* @param     设定文件  
	* @return void    返回类型  
	* @throws
	 */
	public void testHash(){
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("name", "dengchao");
		map.put("age", "27");
		map.put("tel", "123456789");
		jedis.hmset("user",map);
		
		List<String> hmget = jedis.hmget("user","name","age","tel");
		
		for (String str : hmget) {
			System.out.println(str);
		}
		//年龄增加一岁
		jedis.incr("age");
		String age = jedis.get("age");
		System.out.println("改变后的年龄为："+age);
		jedis.hdel("user", "age");
		jedis.del("age");
		System.out.println("删除age键后的值为："+jedis.get("age"));
		System.out.println(jedis.hlen("user"));
		System.out.println(jedis.exists("age"));
		System.out.println(jedis.hkeys("user"));
		System.err.println(jedis.hvals("user"));
	}
	
	/**
	 * 
	* @Title: testLink  
	* @Description: 测试链表 
	* @param     设定文件  
	* @return void    返回类型  
	* @throws
	 */
	public void testLink(){
		
		jedis.flushAll();
		
		jedis.rpush("name","dengchao","age","27","tel","123456");
		jedis.lpush("aaa", "bbbb");
		
		System.out.println(jedis.lrange("aaa", 0, -1));
		
	}
	
	/**
     * redis操作set集合
     * 
     */
    
    public void testSet() {
        
        //添加
        jedis.sadd("user", "liuling");
        jedis.sadd("user", "xinxin");
        jedis.sadd("user","ling");
        jedis.sadd("user", "zhangxinxin");
        jedis.sadd("user", "who");
        
        //删除
        jedis.srem("user", "who");
        System.out.println(jedis.smembers("user"));//获取所有加入的value
        System.out.println(jedis.sismember("user", "who"));//判断who是否是user集合的元素
        System.out.println(jedis.srandmember("user"));
        System.out.println(jedis.scard("user"));//返回集合的元素个数
        
        
        
        
    }
    
    
    /**
     * redis排序
     */
    
    public void testSort() {
        
        //jedis 排序
        //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的)
        jedis.del("a");//先清除数据，再加入数据进行测试
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");
        System.out.println(jedis.lrange("a", 0, -1));
        System.out.println(jedis.sort("a"));//[1,3,6,9] //输入排序后结果
        System.out.println(jedis.lrange("a", 0, -1));
        
        
        
        
    }
	
	public static void main(String[] args) {
		RedisTest test = new RedisTest();
		test.connectRedis();
		
		//test.testString();
		//test.testHash();
		//test.testLink();
		//test.testSet();
		test.testSort();
	}
	
}
