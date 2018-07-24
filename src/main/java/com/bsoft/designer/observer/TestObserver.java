package com.bsoft.designer.observer;

public class TestObserver {

	
	public static void main(String[] args) {
		
		ConcreteSubject subject = new ConcreteSubject();
		ConcreteObserver observer = new ConcreteObserver();
		subject.addObserver(observer);
		subject.doSomething();
	}
}
