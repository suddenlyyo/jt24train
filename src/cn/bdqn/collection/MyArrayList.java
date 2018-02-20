 package cn.bdqn.collection;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {

	
	public static void main(String[] args) {
		
		//接口声明  实现子类实例化  使用泛型
		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<>();
		list2.add("2aa");
		list2.add("2bb");
		//可重复添加
		list.add("aa");
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
//		list.ad
//		list.add(null);//允许null值 多个也行
//		list.add(null);
		
		System.out.println(list.size());
		
		//删除 按指定下标 删完之后后面的元素往前推，如果知道下标通过下标删除。
		System.out.println("==================================");
		list.remove(2); 
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println("==================================");
		//也可以删除对象如果有对象的引用，直接删除引用
		list.remove("dd");
		
		//添加还可以添加一个集合,删除也可以删除一个集合
		
		list.set(2, "设置指定下标位置的值");// 注意不能超过他的size-1
		
		list.get(0);//通过指定下标取值
		
		list.contains("cc");//判断是否包含某个元素,返回布尔值
		list.addAll(list2);
		System.out.println("*************************************************");
		System.out.println(list);
		
		boolean flag = list.containsAll(list2);//判断是否包含一个集合
		System.out.println("是否包含另外一个集合：" + flag);
		
		boolean isEmpty = list.isEmpty();//是否为空集合 就是说没元素,但自身非null不要混淆
		if(isEmpty) {
			System.out.println("是空");
		} else {
			System.out.println("非空");
		}
	}
}
