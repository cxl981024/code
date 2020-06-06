package com.cxl.io4;
//大小
import java.io.File;

import org.apache.commons.io.FileUtils;

public class CIOtest {
public static void main(String[] args) {
	//文件大小
	long len =FileUtils.sizeOf(new File("src/com/cxl/io4/CIOtest.java"));
	System.out.println(len);
	//目录大小
	len =FileUtils.sizeOf(new File("C:/Users/寰/eclipse-workspace/io_study"));
	System.out.println(len);
}
}
