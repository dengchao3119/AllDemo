package com.bsoft.designer.decorator;
/**
 * 被装饰的啤酒类
 * @author ygzx
 *
 */
public class Beer extends Drinks {

	public Beer() {
		name = "啤酒";
	}
	
	@Override
	public float price() {
		return 10;
	}

}
