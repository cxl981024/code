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
				BufferedWriter wr = new BufferedWriter(new FileWri