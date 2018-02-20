package cn.bdqn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 大家作一定了解即可
 * @author Lovely
 *
 */
public class TestReflect {

	
	@Test
	public void field() throws ClassNotFoundException {
		//获取类对象的三种方式
		//第一种方式  如果构造器被私有化了，这种方式就无法使用了，如果通过其它方式已经造 出来对象肯定使用其它方式获取了字节码对象，也意味着它多余
		Object obj = new Object();
		Class<Object> clz1 = (Class<Object>) obj.getClass();
		System.out.println(clz1);
		//第二种方式
		Class<Object> clz2 = Object.class;
		//第三种方式
		Class<Dog> clz3 = (Class<Dog>) Class.forName("cn.bdqn.reflect.Dog");
		
		System.out.println(clz3);
		
		Class<Dog> clazz = Dog.class;
		//获取在本类中声明的所有属性
		Field[] fileds = clazz.getDeclaredFields();
		System.out.println("私有属性");
		//Field 域，字段
		for (Field field : fileds) {
			System.out.println(field);
		}
	}
	
	//构造器私有化,强行实例化
	@Test 
	public void newObject() {
		Class<Dog> clazz = Dog.class;
		try {
			Constructor<Dog> c = clazz.getDeclaredConstructor(null);
			//要实例化 还需要一步 爆破private
			c.setAccessible(true);
			Dog dog = c.newInstance(null);
			dog.sing();
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//执行私有化方法 无参数
	@Test
	public void privateMethod() {
		Class<Dog> clazz = Dog.class;
		//第一个参数为方法名称
		try {
			Constructor<Dog> c = clazz.getDeclaredConstructor(null);
			//要实例化 还需要一步 爆破private
			c.setAccessible(true);
			Dog dog = c.newInstance(null);
			Method method = clazz.getDeclaredMethod("eat", null);
			method.setAccessible(true);
			method.invoke(dog, null);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
	
	//执行私有化方法 有参数
	@Test
	public void privateMethod2() {
		Class<Dog> clazz = Dog.class;
		//第一个参数为方法名称
		try {
			Constructor<Dog> c = clazz.getDeclaredConstructor(null);
			//要实例化 还需要一步 爆破private
			c.setAccessible(true);
			Dog dog = c.newInstance(null);
			//此处第二个参数为参数列表指定的Class对象
			Method method = clazz.getDeclaredMethod("eat", String.class);
			method.setAccessible(true);
			//反射执行，
			method.invoke(dog, "我是可爱的参数");
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
