package com.test.proxy.dynamic.jdk.Impl;


import com.test.proxy.dynamic.jdk.UserService;

/**
 * Description 目标对象接口实现
 * @author playboy
 * @date 2020-04-26 16:23
 * version 1.0
 */
public class UserServiceImpl implements UserService {
	@Override
	public void add(String param) {
		System.out.println("--------------add ("+param+") -------------------");
	}

}
