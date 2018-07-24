package com.bsoft.designer.observer;
/**
 * 被观察者
 * @author ygzx
 *
 */
public class ConcreteSubject extends Subject {
	
	public void doSomething(){
		
		super.notifyObserver();
	}

}
