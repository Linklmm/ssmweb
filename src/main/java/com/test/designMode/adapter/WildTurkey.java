package com.test.designMode.adapter;


/**
 * Description 火鸡类
 * @author playboy
 * @date 2020-01-15 15:17
 * version 1.0
 */
public class WildTurkey implements Turkey {
	@Override
	public void gobble() {
		System.out.println("Gobble gobble");
	}

	@Override
	public void fly() {
		System.out.println("I'm flying a short distance");
	}

}
