package com.cxl.io3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

//文件字符输出流
//1创建源
//2选择流
//3操作（写出内容）
//4释放资源
public class IOTest6 {

	public static void main(String[] args) {
		// 1创建源
		File dest = new File("dest.txt");
		// 2选择流
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(dest));
			// 3.操作（写出）
			//写法1
//			String msg = "IO is so easy\r\n陈晓龙好帅啊 ";
//			char[] datas = msg.toCharArray();// 字符串-->字节数组（编码）
//			writer.write(datas, 0, datas.length);
			//写法2
//			String msg = "IO is so easy\r\n陈晓龙好帅啊 ";
//			writer.write(msg);
//			writer.flush();
			//写法3
			writer.append("IO is so easy陈晓龙好帅啊 ");
			writer.newLine();
			writer.append("帅帅shuaoshsuaoids");
			writer.flush(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if (null != writer) {
				try {
					writer.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

	}
}
