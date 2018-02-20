package cn.bdqn.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class MyDataIo {

	@Test
	public void read(){
		File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "zxy.jpg");
		DataInputStream in = null;
		try {
			in = new DataInputStream(new FileInputStream(file));
			byte[] b = new byte[in.available()];
			//读取
			in.read(b);
			//循环遍历
			for (byte c : b) {
				System.out.println(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//复制zxy.jpg 到类路径下 名称为zxy2.jpg
	@Test
	public void write(){
		File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "zxy.jpg");
		File copyFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "zxy2.jpg");
		
		DataInputStream in = null;
		DataOutputStream out = null;
		
		try {
			in = new DataInputStream(new FileInputStream(file));
			out = new DataOutputStream(new FileOutputStream(copyFile));
			//内容少，一次搞定，一般是需要循环的，循环自行写。
			byte[] b = new byte[in.available()];
			//读取内容  
			in.read(b);
			//写入内容到zxy2.jpg
			out.write(b);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
