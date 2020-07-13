package com.test.algorithm.leetCode;


import com.alibaba.fastjson.JSON;
import java.util.Arrays;

/**
 * Description 66。加一
 * @author playboy
 * @date 2020-07-08 20:37
 * version 1.0
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (9 != digits[i]) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		//如果都是9，则跳出循环
		int[] newDigits = Arrays.copyOf(digits, digits.length + 1);
		newDigits[0] = 1;
		return newDigits;

	}

	public static void main(String[] args) {
		PlusOne plusOne = new PlusOne();
		int[] digits = {9, 9, 9};
		//int[] ns = new int[digits.length+1];
		//ns = Arrays.copyOfRange(digits, 0, digits.length+1);
		//System.out.println(JSON.toJSONString(ns));
		System.out.println(JSON.toJSONString(plusOne.plusOne(digits)));
	}

}
