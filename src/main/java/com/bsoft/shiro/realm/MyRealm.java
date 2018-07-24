package com.bsoft.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm{
	
	@Override
	public String getName() {
		return "myRealm";
	}

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		//获取token中的用户名
		String userName = (String)token.getPrincipal();
		if (!"zhangsan".equals(userName)) {
			return null;
		}
		String password = "666";
		//info对象表示realm登录比对信息，参数一：用户信息（真是登录中用户名）参数二：密码 参数三：realm名称
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,password,getName());
		return info;
	}

	
	
	

}
