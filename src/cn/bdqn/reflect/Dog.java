package cn.bdqn.reflect;

public class Dog {

	
	private Integer age;
	
	private String name;
	
	private Dog() {
		System.out.println("无参构造器执行....");
	}
	
	

	private Dog(Integer age, String name) {
		this.age = age;
		this.name = name;
	}


	
	//私有化方法
	
	private void eat(){
		System.out.println("私有eat执行");
	}

	
	private void eat(String a){
		System.out.println("私有带参数eat执行" +a);
	}
	
	//公开方法
	public void sing() {
		System.out.println("请叫我歌神");
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
