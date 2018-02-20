package cn.bdqn.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class MyFile {

	/**
	 * 【注意：】本类将教大家如何读取本项目类路径下的文件，因为存在本地电脑D盘G盘，但是项目如果不在本地，没有G盘，将会导致没有对应的文件
	 * 所以我们此处使用类路径下的文件进行操作；
	 * 此处采用Junit进行测试，大家双击对应方法run as Junit case即可
	 * 当出现中文读取的时候可能就会出现乱码。
	 * @param
	 * @throws Exception
	 */
	 
	
	//读文件的方法
	@Test
	public void read(){
		
		//System.getProperty("user.dir") 本方法将会获取类路径 大家可以观察这个路径的值
		File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "beatitCN.txt");
		//读取采用输入流，此处使用FileInputStream
		FileInputStream in = null;
		
		try {
			//实例化一个输入流对象
			in = new FileInputStream(file);
			//新建一个数组，将读取的内容存入到一个数组当中
//			byte[] b = new byte[in.available()];//available是得到流中数据有多少个byte
//			
//			//将流的内容存储到b数组当中
//			in.read(b);
//			//b中全是数字比如a 对应97，但是我们想得到原文内容，所以使用String的构造方法
//			String content = new String(b);
//			System.out.println("内容为:\n" + content);
			
			//如果能容很多还是需要使用循环的
			byte[] b = new byte[1024];
			int back;
			String content = "";
			int count = 0;
			while((back = in.read(b)) != -1) {
				content += new String(b);
				b = new byte[1024];
				
//				content += "【】";
				count++;
			}
			System.out.println("内容为：\n" + content);
			System.out.println("历经" +  count + "难，取得真经");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭流资源一定要记住
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	@Test
	public void write(){
		
		//System.getProperty("user.dir") 本方法将会获取类路径 大家可以观察这个路径的值
		File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "text2.txt");
		//读取采用输出流，此处使用FileInputStream
		FileOutputStream out = null;
		
		try {
			//实例化一个输入流对象
			out = new FileOutputStream(file);//如果是追加内容多加一个参数true,其他的类似
			//写入字符串必须打散为byte数组
			out.write("看我写入abc".getBytes());
			out.write("\r\n再次写入我还想换行".getBytes());//\r\n可以实现换行
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭流资源一定要记住
				assert out != null;
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
