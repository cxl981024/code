package com.cxl.io2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//第一个程序：理解操作步骤 标准
//1创建源
//2选择流
//3操作
//4释放资源
public class IOTest2 {
	public static void main(String[] args) {
		// 1.创建源
		File src = new File("abc.txt");
		// 2.选择流
		InputStream is = null;
		try {
			is = new FileInputStream(src);
			// 3操作（读取）
			int temp;
			while ((temp = is.read()) != -1) {
				System.out.println((char) temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			// 4释放资源
			try {
				if (null != is) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
