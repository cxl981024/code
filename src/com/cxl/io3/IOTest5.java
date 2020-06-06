package com.cxl.io3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(src));
			// 3操作（分段读取）
			String line = null;

			while ((line = reader.readLine()) != null) {
				// 字符数组-->字符串（解码）

				System.out.println(line);
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
