
package com.bsoft.designer.decorator;

public class Test {
	
	public static void main(String[] args) {
		
		
		Drinks drinks = new Cola();
		drinks = new Vinegar(drinks);
		drinks = new Water(drinks);
		
		System.out.println("饮品："+drinks.getName()+",价格："+drinks.price());
	}

}
