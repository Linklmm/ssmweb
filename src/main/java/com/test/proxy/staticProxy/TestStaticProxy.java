package com.test.proxy.staticProxy;


import com.test.proxy.staticProxy.Impl.HelloSeriviceImpl;

/**
 * Description 测试静态代理
 *
 * @author playboy
 * @date 2020-04-26 15:48
 * version 1.0
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        //目标对象
        HelloService target = new HelloSeriviceImpl();
        //代理对象
        HelloSeriviceProxy proxy = new HelloSeriviceProxy(target);
        proxy.say();
    }
}
