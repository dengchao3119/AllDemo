package com.bsoft.designer.decorator;

import com.fasterxml.jackson.core.sym.Name;

/**
 * 被装饰的可乐类
 * @author ygzx
 *
 */
public class Cola extends Drinks {

	public Cola() {
		name = "可乐";
	}
	
	@Override
	public float price() {
		return 15;
	}

}
