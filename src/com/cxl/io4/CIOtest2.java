package com.cxl.io4;

//列出子孙集
import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import sun.invoke.empty.Empty;

public class CIOtest2 {
	public static void main(String[] args) {
		Collection<File> files = FileUtils.listFiles(new File("C:/Users/寰/eclipse-workspace/io_study"),
				EmptyFileFilter.NOT_EMPTY, null);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("-------------------------------");
		files = FileUtils.listFiles(new File("C:/Users/寰/eclipse-workspace/io_study"), EmptyFileFilter.NOT_EMPTY,
				DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("--------------------------------");
		files = FileUtils.listFiles(new File("C:/Users/寰/eclipse-workspace/io_study"), FileFilterUtils
				.or(new SuffixFileFilter("java"), new SuffixFileFilter("class"), EmptyFileFilter.NOT_EMPTY),
				DirectoryFileFilter.INSTANCE);// 不为空且为java或class的文件
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
	}
}
