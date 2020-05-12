package com.test.test.pojo;


/**
 * Description
 * @author playboy
 * @date 2020-03-28 10:02
 * version 1.0
 */
public class InstanceVariableInitializer {
	private int i = 1;
	private int j = i + 1;

	public InstanceVariableInitializer(int val) {
		System.out.println(i);
		System.out.println(j);
		this.i = val;
		System.out.println(i);
		System.out.println(j);
	}
	{
		j+=3;
	}

	public static void main(String[] args) {
		new InstanceVariableInitializer(8);
	}
}
