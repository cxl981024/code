package com.cxl.io3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/*
 * 数据流
 * 1.写出后读取
 * 2读取的顺序与写出保持一致
 * 3.不是所有的对象都可以序列化
 * 
 * ObjectOutputStream
 *ObjectInputStream
 */
public class ObjectTest2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 写出--->序列化
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.ser")));
		// 操作数据类型+数据
		oos.writeUTF("床前明月光");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChar('a');
		// 对象
		oos.writeObject("编码辛酸泪");
		oos.writeObject(new Date());
		Emploee emp = new Emploee("陈晓龙", 800);
		oos.writeObject(emp);
		oos.flush();
		oos.close();

		// 读取--反序列化
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")));
		// 顺序与写出一致

		String msg = ois.readUTF();
		int age = ois.readInt();
		boolean flag = ois.readBoolean();
		char ch = ois.readChar();
		System.out.println(flag);
		Object str = ois.readObject();
		Object date = ois.readObject();
		Object employee = ois.readObject();

		if (str instanceof String) {
			String strObj = (String) str;
			System.out.println(strObj);
		}
		if (date instanceof Date) {
			Date dataObj = (Date) date;
			System.out.println(dataObj);
		}
		if (employee instanceof Emploee) {
			Emploee employeeObj = (Emploee) employee;
			System.out.println(employeeObj.getName() + "-->" + employeeObj.getSalary());
		}
		ois.close();
	}
}

//javabean