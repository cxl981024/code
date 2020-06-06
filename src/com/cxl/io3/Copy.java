package com.cxl.io3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//文件拷贝：文件字节输入输出流
//1创建源
//2选择流
//3操作（写出内容）
//4释放资源
public class Copy {

	public static void main(String[] args) {
		copy("src/com/cxl/io3/Copy.java", "one.txt");

		// 文件的拷贝
	}

	public static void copy(String srcPath, String destPath) {
		// 1创建源
		File src = new File(srcPath);// 源头
		File dest = new File(destPath);// 目的地
		// 2选择流
		InputStream is = null;
		OutputStream os = null;
		try (BufferedReader br = new BufferedReader(new FileReader(src));
				BufferedWriter wr = new BufferedWriter(new FileWriter(dest))) {

			// 3操作（分段读取）
			String lene = null;
			while ((lene = br.readLine()) != null) {
				wr.write(lene);
				wr.newLine();
			}
			wr.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 释放资源 分别关闭 先打开得后关闭
			try {
				if (null != os) {
					os.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}

			try {
				if (null != is) {
					is.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public static void copy2(String srcPath, String destPath) {
		// 1创建源
		File src = new File(srcPath);// 源头
		File dest = new File(destPath);// 目的地
		// 2选择流

		try (InputStream is = new FileInputStream(src); OutputStream os = new FileOutputStream(dest);) {

			// 3操作（分段读取）
			byte[] flush = new byte[1024];// 缓冲容器
			int len = -1;// 接收长度
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);// 分段读取
			}
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
