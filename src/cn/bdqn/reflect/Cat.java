package cn.bdqn.reflect;

import java.util.Date;

public class Cat {

	//字段 Field 域 
	private Integer age;
	
	private String sex;
	
	private String name;
	
	private Date birthDay;
	
	private Cat() {
		System.out.println("实例化成功........................");
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	private void eat() {
		System.out.println("猫在吃猫粮................");
	}
	 
	
	private void showDate(Date date) {
		System.out.println("今天是:" + date);
	}
	
}
