package com.test.serialize.destroySerialize;


import com.test.serialize.SerializeConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

/**
 * Description 序列化对单例的破坏
 * @author playboy
 * @date 2020-04-27 11:16
 * version 1.0
 */
@Slf4j
public class SerializableDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//read
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SerializeConstant.FILE));
		Singleton singleton;
		try {
			singleton = Singleton.getSingleton();
			oos.writeObject(singleton);
		} finally {
			IOUtils.closeQuietly(oos);
		}
		//read
		File file = new File(SerializeConstant.FILE);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Singleton newInstance;
		try {
			newInstance = (Singleton) ois.readObject();
		} finally {
			IOUtils.closeQuietly(ois);
		}
		log.info("是否构造了新对象，singleton == newInstance :{}", singleton == newInstance);

	}

}
