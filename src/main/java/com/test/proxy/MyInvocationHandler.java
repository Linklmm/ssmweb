package com.test.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-14 15:00
 * @Version 1.0
 * @Description 创建自定义的InvocationHandler，用于对接口提供的方法进行增强
 */
public class MyInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    /**
     * 执行目标对象的方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在目标对象的方法执行之前简单的打印一下
        System.out.println("-------------before----------");

        //执行目标对象的方法
        Object result = method.invoke(target);

        //在目标对象的方法执行之后简单的打印一下
        System.out.println("-----------after------------");

        return result;
    }

    /**
     * 获取目标对象的代理对象
     *
     * @return
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
}
