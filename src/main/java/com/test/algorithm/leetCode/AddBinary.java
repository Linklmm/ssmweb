package com.test.algorithm.leetCode;


import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Description 67.二进制求和。
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。  输入为 非空 字符串且只包含数字 1 和 0。
 *
 * @author playboy
 * @date 2020-07-10 10:34
 * version 1.0
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        if (ac.length > bc.length) {
            return binary(ac, bc);
        } else {
            return binary(bc, ac);
        }
    }

    /**
     * @param max 比较长的
     * @param min 比较短的
     * @return
     */
    public String binary(char[] max, char[] min) {
        //进位
        int charry = 0;
        for (int i = min.length - 1, a = 1; i >= 0; i--, a++) {
            //两数相加的值
            int sum = (max[max.length - a] - '0' + min[i] - '0') + charry;
            //得到当前值
            max[max.length - a] = (char) (sum % 2 + '0');
            if (sum >= 2) {
                charry = 1;
            } else {
                charry = 0;
            }
        }
        //长的进位
        for (int j = (max.length - min.length) - 1; j >= 0; j--) {
            if (charry == 1) {
                int sum2 = max[j] - '0' + charry;
                max[j] = (char) (sum2 % 2 + '0');
                charry = sum2 > 1 ? 1 : 0;
            }
        }
        //循环后还有进位，则需要加1
        if (charry == 1) {
            char[] result = new char[max.length + 1];
            System.arraycopy(max, 0, result, 1, max.length);
            result[0] = (char) (1 + '0');
            return String.valueOf(result);
        }
        return String.valueOf(max);
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String s = "11";
        String s2 = "11";
        System.out.println(addBinary.addBinary(s, s2));
    }

}
