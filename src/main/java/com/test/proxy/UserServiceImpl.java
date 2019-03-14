package com.test.proxy;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-14 14:58
 * @Version 1.0
 * @Description jdk代理
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("----------------add------------------");
    }
}
