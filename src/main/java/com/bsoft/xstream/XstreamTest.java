package com.bsoft.xstream;


import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
/**
 * 
* @ClassName: XstreamTest  
* @Description: 对象与xml转换  
* @author DENGCHAO
* @date 2018年7月9日 下午4:12:34  
*
 */
public class XstreamTest {
	
	public static void main(String[] args) {
		//采用非注解方式将对象转xml
		String resultXml = beanToXml();
		System.out.println(resultXml);
		System.out.println("-------------------------------------------------------------------");
		//xml转对象
		Bank bank = xmlToBean(resultXml);
		System.out.println(bank);
		System.out.println("*******************************************************************");
		
		//采用注解方式将xml转对象
		String resultXml2 = beanToXmlByAnno();
		System.out.println(resultXml2);
		System.out.println("-------------------------------------------------------------------");
		//xml转对象
		Bank bank2 = xmlToBeanByAnno(resultXml2);
		System.out.println(bank2);
		
	}

	private static Bank xmlToBean(String resultXml) {
		//创建xstream对象
		XStream xStream = new XStream();
		//将别名与xml名字对应
		xStream.alias("bank",Bank.class);
		xStream.alias("account", Account.class);
		//将字符串类型的xml转换为对象
		Bank bank = (Bank)xStream.fromXML(resultXml);
		return bank;
	}

	private static String beanToXml() {
		Bank bank = new Bank();
		Account account1 = new Account();
		Account account2 = new Account();
		account1.setAccoutId(1);
		account1.setAccountName("dengchao");
		account1.setAccountMoeny(100);
		account1.setTelNum("1333333333");
		
		account2.setAccoutId(2);
		account2.setAccountName("sunli");
		account2.setAccountMoeny(200);
		account2.setTelNum("14444444");
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account1);
		accounts.add(account2);
		
		bank.setName("中国人民银行");
		bank.setAddress("地球");
		bank.setAccounts(accounts);
		//创建xstream对象
		XStream xStream = new XStream();
		//给指定类起别名
		xStream.alias("bank", Bank.class);
		xStream.alias("account", Account.class);
		//将对象转换成xml字符串
		String xml = xStream.toXML(bank);
		
		return xml;
	}
	
	private static String beanToXmlByAnno() {
		Bank bank = new Bank();
		Account account1 = new Account();
		Account account2 = new Account();
		account1.setAccoutId(1);
		account1.setAccountName("dengchao");
		account1.setAccountMoeny(100);
		account1.setTelNum("1333333333");
		
		account2.setAccoutId(2);
		account2.setAccountName("sunli");
		account2.setAccountMoeny(200);
		account2.setTelNum("14444444");
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account1);
		accounts.add(account2);
		
		bank.setName("中国人民银行");
		bank.setAddress("地球");
		bank.setAccounts(accounts);
		//创建xstream对象
		XStream xStream = new XStream();
		//使用注解修改对象名称
	    xStream.processAnnotations(new Class[]{Bank.class,Account.class});
		String xml = xStream.toXML(bank);
		
		return xml;
	}
	
	private static Bank xmlToBeanByAnno(String resultXml) {
		//创建xstream对象
		XStream xStream = new XStream();
		//使用注解修改对象名称
	    xStream.processAnnotations(new Class[]{Bank.class,Account.class});
		//将字符串类型的xml转换为对象
		Bank bank = (Bank)xStream.fromXML(resultXml);
		return bank;
	}

}
