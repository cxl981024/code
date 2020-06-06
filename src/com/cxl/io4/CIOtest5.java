package com.cxl.io4;

//拷贝
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import sun.nio.ch.IOUtil;

public class CIOtest5 {
	public static void main(String[] args) throws IOException {
		// 复制文件
		// FileUtils.copyFile(new File("d1.png"), new File("1.png"));
		// 复制文件到目录
		// FileUtils.copyFileToDirectory(new File("d1.png"), new File("dest"));
		// 复制目录到目录
		// FileUtils.copyDirectoryToDirectory(new File("src"), new File("dest"));
		// 复制目录
		// FileUtils.copyDirectory(new File("src"), new File("dest"));
		// 拷贝内容
		// String url ="https://ss3.bdstatic.com/70cFv8Sh_Q1Y"
		// + "nxGkpoWK1HF6hhy/it/u=2534506313,1688529724&fm=26&gp=0.jpg";
		// FileUtils.copyURLToFile(new URL(url), new File("strb.jpg"));
		String data = IOUtils.toString(new URL("http://www.163.com"), "GBK");
		System.out.println(data);
	}

}
