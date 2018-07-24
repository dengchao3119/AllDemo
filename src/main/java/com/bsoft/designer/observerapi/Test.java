package com.bsoft.designer.observerapi;

public class Test {
	
	public static void main(String[] args) {
		MyObservable myObservable = new MyObservable();
		Observer_A a = new Observer_A(myObservable);
		Observer_B b = new Observer_B(myObservable);
		myObservable.setData(5);
		myObservable.deleteObserver(a);
		myObservable.setData(10);
	}

}
