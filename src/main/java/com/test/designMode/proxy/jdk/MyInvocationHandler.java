package com.test.designMode.proxy.jdk;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-05 15:36
 * @description: 调用处理器
 **/
@Slf4j
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.error("proxy:{},method:{},args:{}"
                , JSON.toJSONString(proxy), JSON.toJSONString(method), JSON.toJSONString(args));
        return method.invoke(target, args);
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) handler.getProxy();
        proxy.add();
    }
}
