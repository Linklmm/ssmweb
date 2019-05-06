package com.test.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author
 * @Date 2019-05-06 11:16
 * @Version 1.0
 * @Description Java自带的远程方法调用工具RMI, 对外接口
 */
public interface Iservice extends Remote {
    public String queryName(String no) throws RemoteException;
}
