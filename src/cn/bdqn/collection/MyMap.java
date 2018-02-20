package cn.bdqn.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.bdqn.io.User;

public class MyMap {

	public static void main(String[] args) {

		Map<String, User> map = new HashMap<String, User>();
		
//		Map<String,List<Map<String, User>>>
		// 添加
		map.put("a", new User(18, "悟空"));
		map.put("b", new User(22, "三藏"));

		// 取值
		map.get("a");

		// 删除
		map.remove("b");
//		map.r hashmap hashtable
		
		map.put("a", new User(18, "悟空"));
		map.put("b", new User(22, "三藏"));

		// 迭代方式一
		Set<String> set = map.keySet();
		for (String string : set) {
			System.out.println("key:" + string + ",value " + map.get(string));
		}

		// 迭代方式二
		Iterator<String> it = map.keySet().iterator();
		System.out.println("迭代二.........................");
		while (it.hasNext()) {
			String key = it.next();
			System.out.println("key " + key + ",value " + map.get(key));
		}

		// 迭代方式三
		Iterator<Map.Entry<String, User>> it2 = map.entrySet().iterator();
		System.out.println("entry的使用：");
		while (it2.hasNext()) {
			Map.Entry<String, User> entry = it2.next();
			System.out.println(entry.getKey() + " \t"
					+ entry.getValue().getName());
		}

	}
}
