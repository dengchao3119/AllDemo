package com.bsoft.test;

public class A {
	
	private static A a = new A();
	public static int num1;
	public static int num2 = 0;
	public A() {
		num1++;
		num2++;
	}
	
	public static A getInstance(){
		return a;
	}
	
	public static void main(String[] args) {
		
		A a = A.getInstance();
		System.out.println("num1:"+A.num1);
		System.out.println("num2:"+A.num2);
	}

}
