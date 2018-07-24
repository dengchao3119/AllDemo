package com.bsoft.designer.decorator;
/**
 * 装饰类（加水）
 * @author ygzx
 *
 */
public class Water extends Decorator {
	
	public Water(Drinks drinks) {
		super(drinks);
	}
	
	public void addWater(){
		System.out.println("加水！！！！");
	}
	
	@Override
	public float price() {
		return 1+drinks.price();
	}
	
	@Override
	public String getName() {
		addWater();
		return "加水"+drinks.getName();
	}
	

}
