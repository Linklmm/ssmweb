package com.test.IO;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-05 14:45
 * @description: BIO方式适用于连接数目比较小且固定的架构，
 * 这种方式对服务器资源要求比较高，并发局限于应用中，JDK1.4以前的唯一选择，但程序直观简单易理解。
 **/
public class BIO {
    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        System.out.println(JSON.toJSON(user));

        // write obj to file
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(oos);
        }


        //read obj from file
        File file = new File("tempFile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User newUser = (User) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(ois);
            try {
                FileUtils.forceDelete(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
