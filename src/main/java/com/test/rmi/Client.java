package com.test.rmi;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author
 * @Date 2019-05-06 11:32
 * @Version 1.0
 * @Description RMI客户端
 */
public class Client {
    public static void main(String[] args) {
        //注册管理器
        Registry registry = null;

        try {
            registry = LocateRegistry.getRegistry("127.0.0.1", 8088);
            //列出所有注册的服务
            String[] list = registry.list();
            for (String s : list) {
                System.out.println(s);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        try {
            Iservice server = (Iservice) registry.lookup("vince");
            //调用远程方法
            String result = server.queryName("hhahahahah");
            //输出调用结果
            System.out.println("result from remote: " + result);
        } catch (AccessException e) {

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
