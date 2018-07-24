package com.bsoft.designer.decorator;
/**
 * 装饰类（加醋）
 * @author ygzx
 *
 */
public class Vinegar extends Decorator {
	
	public Vinegar(Drinks drinks) {
	     super(drinks);
	}
	
	public void addVinegar(){
		System.out.println("加醋！！！！！");
	}
	
	@Override
	public float price() {
		
		return 1+drinks.price();
	}
	
	@Override
	public String getName() {
		
		addVinegar();
		return "加醋的"+drinks.getName();
	}
	

}
