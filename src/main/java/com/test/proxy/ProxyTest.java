package com.test.proxy;

import org.junit.jupiter.api.Test;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-14 15:07
 * @Version 1.0
 * @Description jdk代理测试
 */
public class ProxyTest {
    @Test
    public void testProxy() throws Throwable {
        //实例化目标对象
        UserService userService = new UserServiceImpl();

        //实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

        //根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();

        //调用代理对象的方法
        proxy.add();
    }
}
