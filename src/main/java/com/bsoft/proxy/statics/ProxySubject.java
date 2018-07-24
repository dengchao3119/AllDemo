package com.bsoft.proxy.statics;

public class ProxySubject implements Subject{

	private Subject subject;
	
	public ProxySubject(Subject subject) {
		this.subject = subject;
		
	}
	
	public void play() {
		subject.play();
	}

}
