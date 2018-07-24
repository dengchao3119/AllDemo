package com.bsoft.proxy.statics;

public class Test {
	
	public static void main(String[] args) {
		
		ProxySubject subject = new ProxySubject(new RealSubject());
		subject.play();
	}

}
