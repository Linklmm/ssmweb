package com.test.proxy.staticProxy.Impl;


import com.test.proxy.staticProxy.HelloService;

/**
 * Description 静态代理接口实现类
 * @author playboy
 * @date 2020-04-26 15:46
 * version 1.0
 */
public class HelloSeriviceImpl implements HelloService {
	@Override
	public void say() {
		System.out.println("hello world");
	}

}
