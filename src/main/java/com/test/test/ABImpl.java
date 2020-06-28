package com.test.test;


/**
 * Description 实现类
 * @author playboy
 * @date 2020-06-19 09:19
 * version 1.0
 */
public class ABImpl extends B {
	@Override
	public void say() {
		System.out.println("ab");
	}

	public static void main(String[] args) {
		B ab = new ABImpl();
		ab.say();
	}
}
