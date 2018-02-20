package cn.bdqn.io;

import org.junit.Test;

import java.io.*;

public class ReaderAndWriter {

	
	
	public static void main(String[] args) throws IOException {
	
		//测试缓冲写入效果
		BufferedWriter writer = new BufferedWriter(new FileWriter("D:" +File.separator + "text.txt"));
		writer.write("hello1\r\n");
		writer.write("hello2");
		writer.flush();
		writer.write("hello3");
		writer.write("hello4");

		writer.close();
	}
	
	
	
	@Test
	public void testRead(){
		InputStream in = System.in; //创建　获取键盘录入对象 in
        //将字节流对象转成字符流对象,使用转换流 InputStreamReader()
        InputStreamReader isr = new InputStreamReader(in);//传入InputStream in　键盘录入对象 in

        //为了提高效率,将字符串进行缓冲区技术高效操作.使用BufferedReader
        BufferedReader bufr = new BufferedReader(isr);
		try {
			String line = null;
			while ((line = bufr.readLine())!=null)//判断　读取行　非空
            {
                if("over".equals(line))//定义结束标记over
                    break;//退出
                System.out.println(line.toUpperCase());//转换大写输出
            }
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bufr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
