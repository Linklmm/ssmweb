package com.test.designMode.proxy.remote;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import lombok.extern.slf4j.Slf4j;

/**
 * Description 客户端代码
 *
 * @author playboy
 * @date 2020-03-15 10:23
 * version 1.0
 */
@Slf4j
public class MyRemoteClient {
    public void go() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            String s = service.sayHello();
            log.info("返回值为：{}", s);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyRemoteClient().go();
    }
}
