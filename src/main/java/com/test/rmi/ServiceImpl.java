package com.test.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author
 * @Date 2019-05-06 11:20
 * @Version 1.0
 * @Description 服务实现
 */
public class ServiceImpl extends UnicastRemoteObject implements Iservice {
    protected ServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String queryName(String no) throws RemoteException {
        //方法的具体实现
        System.out.println("hello" + no);
        return String.valueOf(System.currentTimeMillis());
    }
}
