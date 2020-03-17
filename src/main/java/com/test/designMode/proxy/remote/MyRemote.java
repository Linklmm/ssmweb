package com.test.designMode.proxy.remote;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Description 远程调用接口
 * @author playboy
 * @date 2020-03-15 10:11
 * version 1.0
 */
public interface MyRemote extends Remote {
	String sayHello() throws RemoteException;
}
