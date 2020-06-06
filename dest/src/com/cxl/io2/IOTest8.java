package com.cxl.io2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//字节数组输出流ByteArrayOutputStream
//1创建源:内部维护
//2选择流:不关联源 
//3操作（写出内容）
//4释放资源：可以不用

//获取数据tobytearray
public class IOTest8 {

	public static void main(String[] args) {
		// 1创建源
		byte[] dest = null;
		// 2选择流
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			// 3.操作（写出）
			String msg = "show me is code ";
			byte[] datas = msg.getBytes();// 字符串-->字节数组（编码）
			baos.write(datas, 0, datas.length);
			baos.flush();
			// 获取数据
			dest = baos.toByteArray();
			System.out.println(dest.length + "-->" + new String(dest, 0, baos.size()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if (null != baos) {
				try {
					baos.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

	}
}
