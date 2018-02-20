package cn.bdqn.collection;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(5);
		list.add(1, 3);
		list.add(3);
		System.out.println(list.contains(3));
		Object[] objs = list.toArray();
		for (Object object : objs) {
			System.out.println("obj:" + object);
		}
		System.out.println(list);
	}
}
