package com.cxl.io4;

//读取文件
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class CIOtest4 {
	public static void main(String[] args) throws IOException {
		// 写出内容
		FileUtils.write(new File("cxl.txt"), "田进小帅哥\r\n", "UTF-8", true);
		FileUtils.writeStringToFile(new File("cxl.txt"), "田进小帅哥\r\n", "UTF-8", true);
		FileUtils.writeByteArrayToFile(new File("cxl.txt"), "学习很痛苦啊".getBytes("UTF-8"), true);

		// 写出列表
		List<String> datas = new ArrayList<String>();
		datas.add("小田");
		datas.add("田一");
		datas.add("田二");

		FileUtils.writeLines(new File("cxl.txt"), datas, "-------", true);

	}

}
