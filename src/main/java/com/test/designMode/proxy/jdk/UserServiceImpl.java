package com.test.designMode.proxy.jdk;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-05 15:35
 * @description: 目标实现类
 **/
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("------------add------------");
    }

    @Override
    public void test() {

    }
}
