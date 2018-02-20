package cn.bdqn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class TestCat {

	public static void main(String[] args) throws Exception{
//		Cat cat = new Cat();
//		第一种方式,先要有Cat的对象
//		Class<Cat> clazz = (Class<Cat>) cat.getClass();
		//第二种
//		Class<Cat> clazz = (Class<Cat>) Class.forName("cn.bdqn.reflect.Cat");
		Class<Cat> clazz = Cat.class;
		Constructor<Cat> con = clazz.getDeclaredConstructor(null);
		con.setAccessible(true);
		Cat cat = con.newInstance(null);
		
		//拿方法
//		Method method = clazz.getDeclaredMethod("eat", null);
//		method.setAccessible(true);
//		method.invoke(cat, null);
		Method method = clazz.getDeclaredMethod("showDate", Date.class);
		method.setAccessible(true);
		method.invoke(cat, new Date());
		
//		 Field[] fileds = clazz.getFields();
//		Field[] fields = clazz.getDeclaredFields();
//		 for (Field field : fields) {
//			System.out.println(field);
//		}
		 
		 
		
	}
}
