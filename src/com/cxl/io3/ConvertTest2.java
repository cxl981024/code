package com.cxl.io3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/*
 * 转换流：InputStreamReader OutputStreamWriter
 * 1.以字符流的形式操作字节流（纯文本的）
 * 2.指定 字符集
 */
public class ConvertTest2 {

	public static void main(String[] args) {
	//操作网络流 下载百度的源代码
		try(InputStreamReader is=	new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8") ;){
			int temp;
			while ((temp = is.read()) != -1) {
				System.out.print((char) temp);
			}
			}catch (IOException e) {
			System.out.println("输入有误");
		}
	}
}