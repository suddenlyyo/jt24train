package cn.bdqn.basic;

import org.junit.Test;

public class BasicData {

	//内容了解即可 
	@Test
	public void m1(){
		//25 转2进制对应的数
		System.out.println(Integer.toBinaryString(25));
		//25转十六进制
		System.out.println(Integer.toHexString(25));
		//25转8进制
		System.out.println(Integer.toOctalString(25));
		
		
		//申明方式也可以改变
		int a = 100_1000;
		System.out.println(a);
		
		//以数字零开头代表八进制 打印数字是以10进制显示  这里不是字母o
		int b = 025;
		System.out.println(b);
		
		//数字零加x开头代表16进制
		int c = 0x13;
		System.out.println(c);
	}
	
	@Test
	public void m2(){
		Integer a = 127;
		Integer b = 127;
		System.out.println(a == b);//观察结果
		
		
		Integer c = 128;
		Integer d = 128;
		System.out.println(c == d);//观察结果
		
		//结论:-128 到127是相等的 ,超过此范围不相等.记住即可 深究可看源码
	}
	
	@Test
	public void m3() {
		char a = 'a';
		int b = 97;
		System.out.println(a == b);//根据结果思考含义?
	}
	
}
