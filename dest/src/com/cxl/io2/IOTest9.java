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

//1图片读取到直接数组中
//2字节数组写出到文件

public class IOTest9 {

	public static void main(String[] args) {
		// 图片转换成字符组
		byte[] datas = fileToByteArray("copy.png");
		System.out.println(datas.length);
		byteArrayTofile(datas, "d1.png");
	}
	// 1图片读取到字节数组
	// 图片到程序FileInputStream
	// 程序到字节数组ByteArrayOutPutStream
	public static byte[] fileToByteArray(String filePath) {
		// 1.创建源与目的地
		File src = new File(filePath);
		byte[] dest = null;
		// 2.选择流
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			is = new FileInputStream(src);
			baos = new ByteArrayOutputStream();
			// 3操作（分段读取）
			byte[] flush = new byte[1024 * 50];// 缓冲容器
			int len = -1;// 接收长度
			while ((len = is.read(flush)) != -1) {
				baos.write(flush, 0, len);// 写出到字节数中
			}
			baos.flush();
			return baos.toByteArray();
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
		return null;
	}

	// 字节数组写出图片
	// 字节数组到程序ByteArrayToFile
	// 程序到文件FileOutPutStream
	public static void byteArrayTofile(byte[] src, String filePath) {
		// 1.创建源
		File dest = new File(filePath);
		// 2.选择流
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new ByteArrayInputStream(src);
			os = new FileOutputStream(dest);
			// 3操作（分段读取）
			byte[] flush = new byte[1024];// 缓冲容器
			int len = -1;// 接收长度
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);// 写出到文件
			}
			os.flush();
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
