package com.cxl.io3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/*
 * 随机读取和写入流 RandomAccessFile
 */
public class FileSpilt {
	// 源头
	private File src;
	// 目的地（文件夹）
	private String destDir;
	// 所有分割后的文件存储路径
	private List<String> destPasth;
	// 每块大小
	private int bolockSize;
	// 块数：多少块
	private int size;

	public FileSpilt(String srcPath, String destDir, int bolockSize) {
		this.src = new File(srcPath);
		this.destDir = destDir;
		this.bolockSize = bolockSize;
		this.destPasth = new ArrayList<String>();
		init();
		// 初始化
	}

	// 初始化
	private void init() {
		// 总长度
		long len = this.src.length();
		// 多少块
		this.size = (int) Math.ceil(len * 1.0 / bolockSize);
		// 路径
		for (int i = 0; i < size; i++) {
			this.destPasth.add(this.destDir + "/" + i + "-" + this.src.getName());
		}

	}

	/*
	 * 分割 1.计算每一块起始位置的大小 2.分割
	 */
	private void split() throws IOException {
		// 总长度
		long len = src.length();
		int beginPos = 0;
		int actualSize = (int) (bolockSize > len ? len : bolockSize);
		for (int i = 0; i < size; i++) {
			beginPos = i * bolockSize;
			if (i == size - 1) {// 最后一块
				actualSize = (int) len;
			} else {
				actualSize = bolockSize;
				len -= actualSize;// 剩余量
			}
			splitDetail(i, beginPos, actualSize);

		}
	}

	/*
	 * 指定d第i块的起始位置和实际长度
	 */
	private void splitDetail(int i, int beginPos, int actualSize) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(this.src, "r");
		RandomAccessFile raf2 = new RandomAccessFile(this.destPasth.get(i), "rw");

		// 随机读取
		raf.seek(beginPos);

		byte[] flush = new byte[1024];// 缓冲容器
		int len = -1;// 接收长度s
		while ((len = raf.read(flush)) != -1) {

			if (actualSize > len) {// 获取本次读取的所有内容
				System.out.println(new String(flush, 0, len));
				raf2.write(flush, 0, len);
				actualSize -= len;
			} else {
				raf2.write(flush, 0, actualSize);
				break;
			}
		}
		raf2.close();
		raf.close();
	}

	/*
	 * 文件的合并
	 */
	public void merge(String destPath) throws IOException {
		// 输出流
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath, true));
		// 输入流
		for (int i = 0; i < destPasth.size(); i++) {
			InputStream is = new BufferedInputStream(new FileInputStream(destPasth.get(i)));

			// 3操作（分段读取）
			byte[] flush = new byte[1024];// 缓冲容器
			int len = -1;// 接收长度
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);// 分段读取
			}
			os.flush();
			is.close();
		}
		os.close();
	}

	public static void main(String[] args) throws IOException {
		FileSpilt sf = new FileSpilt("src/com/cxl/io3/Copy.java", "dest", 1024);
		sf.split();
		sf.merge("cxl.java");
	}
}