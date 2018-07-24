package com.bsoft.designer.observerapi;

import java.util.Observable;
import java.util.Observer;

public class Observer_A implements Observer{
	
	public Observer_A(MyObservable observable) {
		observable.addObserver(this);
	}
	
	public void update(Observable o, Object arg) {
		System.out.println("Observer_A receive:Data has changed to "+((MyObservable) o).getData());
	}

	

}
