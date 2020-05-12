package com.test.proxy.dynamic.jdk;


import com.alibaba.fastjson.JSON;
import com.test.proxy.dynamic.jdk.Impl.UserServiceImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description 调用处理器
 * @author playboy
 * @date 2020-04-26 16:24
 * version 1.0
 */
public class MyInvocationHandler implements InvocationHandler {
	private Object target;

	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("-------before "+ JSON.toJSONString(method.getParameterTypes())+"-----------");
		Object result = method.invoke(target,args);
		System.out.println("-----end "+method.getName()+"--------");
		return result;
	}

	public Object getPorxy() {
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
	}

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		MyInvocationHandler handler = new MyInvocationHandler(userService);
		UserService proxy = (UserService) handler.getPorxy();
		proxy.add("test");
	}

}
