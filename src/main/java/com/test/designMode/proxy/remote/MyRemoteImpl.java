package com.test.designMode.proxy.remote;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

/**
 * Description 远程接口实现
 * @author playboy
 * @date 2020-03-15 10:13
 * version 1.0
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
	protected MyRemoteImpl() throws RemoteException {
	}

	@Override
	public String sayHello() throws RemoteException {
		return "Serve says,'hey'";
	}

	@Override
	public RemoteRef getRef() {
		return super.getRef();
	}

	public static void main(String[] args) {
		try {
			MyRemote service = new MyRemoteImpl();
			Naming.rebind("RemoteHello", service);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
