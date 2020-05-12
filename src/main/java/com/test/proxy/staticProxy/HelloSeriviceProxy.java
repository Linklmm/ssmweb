package com.test.proxy.staticProxy;



/**
 * Description 代理对象
 * @author playboy
 * @date 2020-04-26 15:47
 * version 1.0
 */
public class HelloSeriviceProxy implements HelloService {
	private HelloService targe;

	public HelloSeriviceProxy(HelloService targe) {
		this.targe = targe;
	}

	@Override
	public void say() {
		System.out.println("记录日志");
		targe.say();
		System.out.println("清理数据");
	}

}
