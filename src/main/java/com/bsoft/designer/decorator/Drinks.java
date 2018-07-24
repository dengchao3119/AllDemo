package com.bsoft.designer.decorator;
/**
 * 装饰者模式最顶级的父类
 * （饮料类）
 * @author ygzx
 *
 */
public abstract class Drinks {
	
	public String name;
	
	public abstract float price();

	
	public String getName() {
		return name;
	}
}
