package com.bsoft.shiro.test;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * 
* @ClassName: ShiroTest  
* @Description: 测试shiro认证
* @author DENGCHAO
* @date 2018年6月13日 下午4:38:52  
*
 */
public class ShiroTest {
	
	
	/**
	 * 
	* @Title: testHasRoles  
	* @Description:是否拥有某个角色权限
	* @param     设定文件  
	* @return void    返回类型  
	* @throws
	 */
	@Test
	public void testHasRoleByRealm() {
		//创建securityManager工厂对象：加载配置文件，创建工厂对象
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-permission-realm.ini");	
		//通过工厂对象，创建securitymanager对象
		SecurityManager securityManager = factory.getInstance();
		//将securitymanager绑定到当前运行环境中：让系统随时随地都可以访问securitymanager对象
		SecurityUtils.setSecurityManager(securityManager);
		//创建当前登录主题，注意：此时主题没有经过认证
		Subject subject = SecurityUtils.getSubject();
		//绑定主体登录的身份/凭证，即账号密码
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","666");
		//主体登录
		subject.login(token);
		
		System.out.println(subject.hasRole("role1"));
		System.out.println(subject.isPermitted("user:create"));

	}
	/**
	 * 
	* @Title: testHasRoles  
	* @Description:是否拥有某个角色权限
	* @param     设定文件  
	* @return void    返回类型  
	* @throws
	 */
	@Test
	public void testHasRole() {
		//创建securityManager工厂对象：加载配置文件，创建工厂对象
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");	
		//通过工厂对象，创建securitymanager对象
		SecurityManager securityManager = factory.getInstance();
		//将securitymanager绑定到当前运行环境中：让系统随时随地都可以访问securitymanager对象
		SecurityUtils.setSecurityManager(securityManager);
		//创建当前登录主题，注意：此时主题没有经过认证
		Subject subject = SecurityUtils.getSubject();
		//绑定主体登录的身份/凭证，即账号密码
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","666");
		//主体登录
		subject.login(token);
		//判断是否拥有权限，需要先登录
		
		System.out.println(subject.isPermitted("user:create"));
		System.out.println(subject.isPermitted("user:delete"));
		System.out.println(subject.isPermittedAll("user:create","user:update"));
		System.out.println(subject.isPermittedAll("user:create","user:delete"));
		

		//判断是否拥有某个角色，需要先登录
		
		//有返回参数的权限判断
		/*System.out.println(subject.hasRole("role1"));
		System.out.println(subject.hasRole("role3"));
		System.out.println(Arrays.toString(subject.hasRoles(Arrays.asList("role1","role2"))));
		System.out.println(Arrays.toString(subject.hasRoles(Arrays.asList("role1","role2","role3"))));*/
		
		//无返回值的判断
		/*subject.checkRole("role1");
		subject.checkRole("role4");*/
		/*subject.checkRoles("role1","role2");
		subject.checkRoles("role1","role2","role3");
		subject.checkRoles(Arrays.asList("role1","role2"));
		subject.checkRoles(Arrays.asList("role1","role2","role3"));*/
	
		
		
		
		
		
		
	}

	@Test
	public void test() {
		//创建securityManager工厂对象：加载配置文件，创建工厂对象
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");	
		//通过工厂对象，创建securitymanager对象
		SecurityManager securityManager = factory.getInstance();
		//将securitymanager绑定到当前运行环境中：让系统随时随地都可以访问securitymanager对象
		SecurityUtils.setSecurityManager(securityManager);
		//创建当前登录主题，注意：此时主题没有经过认证
		Subject subject = SecurityUtils.getSubject();
		//绑定主体登录的身份/凭证，即账号密码
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","666");
		//主体登录
		subject.login(token);
		//判断登录是否成功
		System.out.println("验证登录是否成功："+subject.isAuthenticated());
		//登出
		subject.logout();
		System.out.println("验证登录是否成功："+subject.isAuthenticated());
		
	}
	
	/**
	 * 
	* @Title: testMyRealm  
	* @Description: 自定义realm  
	* @param     设定文件  
	* @return void    返回类型  
	* @throws
	 */
	@Test
	public void testMyRealm() {
		//创建securityManager工厂对象：加载配置文件，创建工厂对象
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");	
		//通过工厂对象，创建securitymanager对象
		SecurityManager securityManager = factory.getInstance();
		//将securitymanager绑定到当前运行环境中：让系统随时随地都可以访问securitymanager对象
		SecurityUtils.setSecurityManager(securityManager);
		//创建当前登录主题，注意：此时主题没有经过认证
		Subject subject = SecurityUtils.getSubject();
		//绑定主体登录的身份/凭证，即账号密码
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","666");
		//主体登录
		subject.login(token);
		//判断登录是否成功
		System.out.println("验证登录是否成功："+subject.isAuthenticated());
		//登出
		subject.logout();
		System.out.println("验证登录是否成功："+subject.isAuthenticated());
		
	}

}
