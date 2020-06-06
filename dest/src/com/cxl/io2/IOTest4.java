package com.cxl.io2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//文件字节输出流
//1创建源
//2选择流
//3操作（写出内容）
//4释放资源
public class IOTest4 {

	public static void main(String[] args) {
		// 1创建源
		File dest = new File("dest.txt");
		// 2选择流
		OutputStream os = null;
		try {
			os = new FileOutputStream(dest,true);
			// 3.操作（写出）
			String msg = "IO is so easy\r\n ";
			byte[] datas = msg.getBytes();// 字符串-->字节数组（编码）
			os.write(datas, 0, datas.length);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

	}
}
