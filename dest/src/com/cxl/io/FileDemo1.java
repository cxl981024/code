package com.cxl.io;

import java.io.File;

public class FileDemo1 {
//构建file对象 
	public static void main(String[] args) {
		
		String path="C:/Users/寰/eclipse-workspace/io_study";
		
		//1构建file对象
		File src = new File(path);
		System.out.println(src.length());
		
		
		//2.构建file对象
		src =new File("C:/Users/寰/eclipse-workspace","io_study");
	
		System.out.println(src.length());
		
		//3.构建file对象
		src =new File(new File("C:/Users/寰/eclipse-workspace"),"io_study");
		System.out.println(src.length());
	}
}
