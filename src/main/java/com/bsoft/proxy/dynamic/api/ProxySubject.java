package com.bsoft.proxy.dynamic.api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxySubject {

	private static void before() {
		System.out.println("方法执行前 !");
	}

	private static void after() {
		System.out.println("方法执行后");
	}

	public static void main(String[] args) {

		final Subject subject = new RealSubject();
		Subject proxy = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),
				subject.getClass().getInterfaces(), new InvocationHandler() {
					
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						before();
						Object object = method.invoke(subject, args);
						after();
						return object;
					}
				});
		proxy.play();
	}

}
