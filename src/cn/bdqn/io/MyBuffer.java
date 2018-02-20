package cn.bdqn.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * 本类用在经常读取文本内容一行行读
 * @author Administrator
 *
 */
public class MyBuffer {

	@Test
	public void read(){
		
		//System.getProperty("user.dir") 本方法将会获取类路径 大家可以观察这个路径的值
		File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "beatitCN.txt");
		//读取采用输入流，此处使用FileInputStream
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String back = null;
			String content = "";
			while((back = in.readLine()) != null) {
				content += back + "\n";
			}
			System.out.println("一行一行读内容为：\n" + content );
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭流资源一定要记住
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
	}
	
	@Test
	public void write() {
		//System.getProperty("user.dir") 本方法将会获取类路径 大家可以观察这个路径的值
		File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "text2.txt");
		BufferedWriter bw = null;
		try {
			//获取流实例
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			//写入内容
			bw.write("东风不与周郎便");
			//换行
			bw.newLine();
			bw.write("铜雀春深锁二乔");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				assert bw != null;
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
