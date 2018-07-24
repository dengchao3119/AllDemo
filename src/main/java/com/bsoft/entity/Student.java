package com.bsoft.entity;

/**
 * 
* @ClassName: Student  
* @Description: 通过反射获取
* @author DENGCHAO
* @date 2018年6月6日 上午9:25:44  
*
 */
public class Student {
	
	public String name;  
    protected int age;  
    char sex;  
    private String phoneNum;  
	
	public Student(){
		
		System.out.println("************无参构造方法************");
	}
	
	public Student(String name){
		System.out.println("*****一个参数构造方法*****"+name);
	}
      
    //有多个参数的构造方法  
    public Student(String name ,int age){  
        System.out.println("姓名："+name+"年龄："+ age);  
    }  
      
    //受保护的构造方法  
    protected Student(boolean n){  
        System.out.println("受保护的构造方法 n = " + n);  
    }  
      
    //私有构造方法  
    private Student(int age){  
        System.out.println("私有的构造方法   年龄："+ age);  
    }

    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	
	public void show1(String s){  
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);  
    }  
    protected void show2(){  
        System.out.println("调用了：受保护的，无参的show2()");  
    }  
    void show3(){  
        System.out.println("调用了：默认的，无参的show3()");  
    }  
    private String show4(int age){  
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);  
        return "abcd";  
    }  
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + ", phoneNum=" + phoneNum + "]";
	} 
    
    
}
