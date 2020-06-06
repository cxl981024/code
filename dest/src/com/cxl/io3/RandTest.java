package com.cxl.io3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 随机读取和写入流 RandomAccessFile
 */
public class RandTest {

	public static void main(String[] args) throws IOException {
		//分多少块
		File src =new File("src/com/cxl/io3/Copy.java");
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
			 spilet(i, behinpos, autulsize);
		}
	}

	//指定起始位置，读取剩余所有内容
public static void test1() throws IOException {
	RandomAccessFile raf = new RandomAccessFile(new File("src/com/cxl/io3/Copy.java"), "r");
	//随机读取
	raf.seek(2);
	
	byte[] flush = new byte[1024];// 缓冲容器
	int len = -1;// 接收长度
	while ((len = raf.read(flush)) != -1) {
	System.out.println(new String(flush,0,len));
	} 
	raf.close();
}
//分块思想：起始 ，实际大小，
public static void test2(String[] args) throws IOException {
	
	RandomAccessFile raf = new RandomAccessFile(new File("src/com/cxl/io3/Copy.java"), "r");
	//起始位置
	int beginPos =2+1026;
	//实际大小
	int actualSize = 1026;
	
	//随机读取
	raf.seek(beginPos );
	
	byte[] flush = new byte[1024];// 缓冲容器
	int len = -1;// 接收长度
	while ((len = raf.read(flush)) != -1) {
	
	if(actualSize>len) {//获取本次读取的所有内容
		System.out.println(new String(flush,0,len));
		actualSize-=len;
	}else {
		System.out.println(new String(flush,0,actualSize));
		break;
	}
	}
	raf.close();
}
public static void spilet(int i,int behinpos,int autulsize ) throws IOException {
	
	RandomAccessFile raf = new RandomAccessFile(new File("src/com/cxl/io3/Copy.java"), "r");
	
	
	byte[] flush = new byte[1024];// 缓冲容器
	int len = -1;// 接收长度
	while ((len = raf.read(flush)) != -1) {
	
	if(behinpos>len) {//获取本次读取的所有内容
		System.out.println(new String(flush,0,len));
		autulsize-=len;
	}else {
		System.out.println(new String(flush,0,autulsize));
		break;
	}
	}
	raf.close();
}
}