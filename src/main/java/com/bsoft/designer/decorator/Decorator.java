package com.bsoft.designer.decorator;

/**
 * 所有装饰者的父类
 * @author ygzx
 *
 */
public class Decorator extends Drinks {

	protected Drinks drinks;
	
	public Decorator(Drinks drinks) {
		this.drinks = drinks;
	}
	
	@Override
	public float price() {
		
		return 5;
		
	}

}
