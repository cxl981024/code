package com.cxl.io3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 随机读取和写入流 RandomAccessFile
 */
public class RandTest2 {
	public static void main(String[] args) throws IOException {
		//分多少块
		File src =new File("d1.png");
		//总长度
		long len =src.length();
		//每块大小
		int blockSize= 10;
		//多少块
		int size =(int) Math.ceil(len*1.0/blockSize);
		System.out.println(size);
		
		int behinpos = 0;
		int autulsize=(int) ( blockSize>len?len:blockSize);
		for(int i =0;i<size;i++) {
			behinpos = i*blockSize;
			if(i==size-1) {//最后一块
				autulsize = (int) len;
			}else {
				autulsize =blockSize;
				len-=autulsize;//剩余量
			}
			 System.out.println(i+"-->"+behinpos+"-->"+autulsize);
			 split(i, behinpos, autulsize);
		}
	}
	
	public static void split(int i, int beginPos, int actualSize) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("d1.png"), "r");
		RandomAccessFile raf2 = new RandomAccessFile(new File("dest/" + i + "d1.png"), "rw");

		// 随机读取
		raf.seek(beginPos);

		byte[] flush = new byte[1024];// 缓冲容器
		int len = -1;// 接收长度
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

}