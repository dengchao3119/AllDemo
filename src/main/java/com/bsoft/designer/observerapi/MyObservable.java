package com.bsoft.designer.observerapi;

import java.util.Observable;

public class MyObservable extends Observable {

	private int data = 0;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		if (this.data!=data) {
			this.data = data;
			setChanged();
			notifyObservers();
		}
		
	}
	
	
}
