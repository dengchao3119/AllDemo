package com.bsoft.cn;

public class Test {
	
	public static void main(String[] args) {
		String aa = "预约订单[900000266]已取消(重发)!";
		String bb = aa.substring(0, aa.indexOf("["))+aa.substring(aa.indexOf("]")+1,aa.length());
		System.out.println(bb);
		System.out.println(aa.contains("预约订单已取消(重发)!"));
	}

}
