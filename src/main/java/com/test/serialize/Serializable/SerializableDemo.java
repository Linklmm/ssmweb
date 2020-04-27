package com.test.serialize.Serializable;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.commons.io.IOUtils;

/**
 * Description 测试Serializable序列化
 * @author playboy
 * @date 2020-04-27 08:58
 * version 1.0
 */
public class SerializableDemo {
	private static final String FILE = "tempfile";

	public static void main(String[] args) {

		ObjectOutputStream oos = null;
		User user = new User();
		user.setName("playboy");
		user.setAge(25);
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE));
			oos.writeObject(user);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(oos);
		}

		ObjectInputStream ois = null;
		File file = new File(FILE);
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			User newInstance = (User) ois.readObject();
			System.out.println(newInstance);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(ois);
		}

	}

}
