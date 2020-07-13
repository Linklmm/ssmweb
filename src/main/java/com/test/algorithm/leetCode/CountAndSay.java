package com.test.algorithm.leetCode;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * 注意：整数序列中的每一项将表示为一个字符串。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/count-and-say 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author playboy
 * @date 2020-07-07 20:43
 * version 1.0
 * 递归的方式解决
 */
public class CountAndSay {
	public String countAndSay(int n) {
		//拼接字符
		StringBuilder sb = new StringBuilder();
		if (1 == n) {
			return "1";
		} else {
			//得到上一个的字符数组
			char[] c = countAndSay(n - 1).toCharArray();

			int j = 1;
			if (1 == c.length) {
				return sb.append("11").toString();
			}

			//记录总数
			int i = 0;
			for (i = 0; j < c.length; j++) {
				//如果不相等,则从j开始，重新计数，字符记录到map中
				if (c[i] != c[j]) {
					//记录相同数的总数
					sb.append(j - i).append(c[i]);
					//从j开始，如果j是最后一位且不相等，则
					i = j;
				}
			}
			sb.append(j - i).append(c[i]);
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		CountAndSay countAndSay = new CountAndSay();
		System.out.println(countAndSay.countAndSay(4));
	}

}
