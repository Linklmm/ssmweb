package com.test.serialize.externalize;


import com.test.serialize.SerializeConstant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.io.IOUtils;

/**
 * Description 序列化代码实现
 *
 * @author playboy
 * @date 2020-04-27 08:45
 * version 1.0
 */
public class ExternalizableDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写对象到文件上
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(SerializeConstant.FILE));
            User user = new User();
            user.setAge(23);
            user.setName("lmm");
            oos.writeObject(user);
        } finally {
            IOUtils.closeQuietly(oos);
        }
        //读对象到文件上
        File file = new File(SerializeConstant.FILE);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        try {
            User newInstance = (User) ois.readObject();
            System.out.println(newInstance);
        } finally {
            IOUtils.closeQuietly(ois);
        }

    }

}
