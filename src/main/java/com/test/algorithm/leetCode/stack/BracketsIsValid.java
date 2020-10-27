package com.test.algorithm.leetCode.stack;


import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

/**
 * Description 有效括号
 * @author playboy
 * @date 2020-07-05 15:46
 * version 1.0
 */
public class BracketsIsValid {
	public static boolean isValid(String s) {
		char[] ss = s.toCharArray();
		//'('
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < ss.length; i++) {
			//入栈
			if (ss[i] == '(') {
				stack.push('(');
			}
			if (ss[i] == '[') {
				stack.push('[');
			}
			if (ss[i] == '{') {
				stack.push('{');
			}

			//出栈比较
			if (stack.size() != 0) {
				if (ss[i] == ')') {
					//和栈顶元素不匹配直接返回false
					if (!stack.pop().equals('(')) {
						return false;
					}
				}
				if (ss[i] == ']') {
					//和栈顶元素不匹配直接返回false
					if (!stack.pop().equals('[')) {
						return false;
					}
				}
				if (ss[i] == '}') {
					//和栈顶元素不匹配直接返回false
					if (!stack.pop().equals('{')) {
						return false;
					}
				}
			}else {
				return false;
			}

		}

		if (stack.size() != 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValid("]"));
	}

}
