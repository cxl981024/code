package com.cxl.io4;

//拷贝
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class CIOtest5 {
	public static void main(String[] args) throws IOException {
	//复制文件
	//	FileUtils.copyFile(new File("d1.png"), new File("1.png"));
		//复制文件到目录
		//FileUtils.copyFileToDirectory(new File("d1.png"), new File("dest"));
		//复制目录到目录
		FileUtils.copyDirectoryToDirectory(new File("src"), new File("dest"));
	}

}
