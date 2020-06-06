package com.cxl.io4;

//读取文件
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class CIOtest3 {
	public static void main(String[] args) throws IOException {
		String msg = FileUtils.readFileToString(new File("abc.txt"), "UTF-8");
		System.out.println(msg);
		byte[] datas = FileUtils.readFileToByteArray(new File("abc.txt"));
		System.out.println(datas.length);

		// 逐行读取
		List<String> msgs = FileUtils.readLines(new File("abc.txt"), "UTF-8");
		for (String string : msgs) {
			System.out.println(string);
		}
		LineIterator it = FileUtils.lineIterator(new File("abc.txt"), "UTF-8");
		while (it.hasNext()) {
			System.out.println(it.nextLine());
		}

	}
}
