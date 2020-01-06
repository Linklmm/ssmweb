package com.test.designMode.decorate;


import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Description 测试I/O装饰者
 * @author playboy
 * @date 2020-01-06 09:23
 * version 1.0
 */
public class InputTest {
	public static void main(String[] args) {
		int c;
		try {
			InputStream in = new LowerCaseInputStream(new FileInputStream("/Users/playboy/Java/workSpace/ssmweb/src/main/java/com/test/designMode/decorate/test.txt"));
			while ((c=in.read())>=0){
				System.out.print((char) c);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
