package com.cxl.io2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

//第一个程序：理解操作步骤 标准
//1创建源
//2选择流
//3操作
//4释放资源
public class IOTest5 {
	public static void main(String[] args) {
		// 1.创建源
		File src = new File("abc.txt");
		// 2.选择流
		Reader reader = null;
		try {
			reader = new FileReader(src);
			// 3操作（分段读取）
			char[] flush = new char[1024];// 缓冲容器
			int len = -1;// 接收长度
			while ((len = reader.read(flush)) != -1) {
				// 字符数组-->字符串（解码）
				String str = new String(flush, 0, len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4释放资源
			try {
				if (null != reader) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
