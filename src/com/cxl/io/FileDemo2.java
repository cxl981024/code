package com.cxl.io;

import java.io.File;

//构建File对象 相对路径和绝对路径  1.存在盘符：绝对路径2.不存在盘符：相对路径
public class FileDemo2 {

	public static void main(String[] args) {

		String path = "C:/Users/寰/eclipse-workspace/io_study";

		// 绝对路径
		File src = new File(path);
		System.out.println(src.getAbsolutePath());

		// 相对路径
		System.out.println(System.getProperty("user.dir"));
		src = new File("io_study");
		System.out.println(src.getAbsolutePath());

		// 构建一个不存在得路径
		src = new File("aaa/io_study");
		System.out.println(src.getAbsolutePath());

	}
}
