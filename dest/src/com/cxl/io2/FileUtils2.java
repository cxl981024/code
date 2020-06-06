package com.cxl.io2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sun.xml.internal.ws.Closeable;

/*
  * 1封装拷贝
  * 2封装释放资源
  */
public class FileUtils2 {

	public static void main(String[] args) {
	//文件到文件
		try {
			InputStream is = new FileInputStream("abc.txt");
			OutputStream os =new FileOutputStream("abc-copy.txt");
			copy(is, os);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		//文件到字节数组 
		byte []datas =null; 
		try {
			InputStream is = new FileInputStream("d1.png");
			ByteArrayOutputStream os =new ByteArrayOutputStream();
			copy(is, os);
			 datas= os.toByteArray();
			System.out.println(datas.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//字节数组到文件
		try {
			InputStream is = new ByteArrayInputStream(datas);
			OutputStream os =new FileOutputStream("abc-copy.png");
			copy(is, os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 对接输入输出流
	 */
	public static void copy(InputStream is,OutputStream os) {
		
				try{
				
					// 3操作（分段读取）
					byte[] flush = new byte[1024];// 缓冲容器
					int len = -1;// 接收长度
					while ((len = is.read(flush)) != -1) {
						os.write(flush, 0, len);//分段读取
					}
					os.flush();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
	}
}