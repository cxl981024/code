package com.cxl.io;

import java.io.File;
//名称分隔符separator
public class PathDemo1 {

	public static void main(String[] args) {
		String path = "C:\\Users\\寰\\eclipse-workspace\\io_study";
		System.out.println(File.separatorChar);
		
		//建议
		//1.
		path= "C:/Users/寰/eclipse-workspace/io_study";
		System.out.println(path);
		//2.常量拼接
		 path="C:"+File.separator+"Users"+File.separator+"寰"+File.separator+"eclipse-workspace"+File.separator+"io_study";
		 System.out.println(path);
	}
}
