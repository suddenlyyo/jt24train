package cn.bdqn.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * 此类中包含了序列化反序列化,User类实现了可序列化接口
 * @author Lovely
 *
 */
public class MyObjectIo {

	@Test
	public void writeObject() {
		File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "obj.txt");
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(file));
			//创建对象
			User u = new User(18, "张信哲");
			out.writeObject(u);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Test
	public void readObject() {
		File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "obj.txt");
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(file));
			//读取
			Object o = in.readObject();
			//将对象转换为User对象
			User u = (User)o;
			//输出信息检查是否正确
			System.out.println(u.getAge());
			System.out.println(u.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
