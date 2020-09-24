package com.test.test;


/**
 * Description
 * @author playboy
 * @date 2020-06-19 09:20
 * version 1.0
 */
public interface B extends A ,C{
	@Override
	default void say() {
		System.out.println("b");
	}

}
