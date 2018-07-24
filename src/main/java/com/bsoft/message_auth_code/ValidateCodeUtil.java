package com.bsoft.message_auth_code;

import java.util.Random;
/**
 * 
* @ClassName: ValidateCode  
* @Description: 生成6位数纯数字验证码  
* @author DENGCHAO
*
 */
public class ValidateCodeUtil {

	public static String createData() {
		return createData(6);
	}

	public static String createData(int length) {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(rand.nextInt(10));
		}
		return sb.toString();
	}

}
