package com.test.algorithm.book.first;

import com.test.algorithm.book.common.StdIn;
import com.test.algorithm.book.common.StdOut;
import com.test.algorithm.book.dataStructure.Stack;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-06-14 22:04
 * @description: 双栈算术表达式求值算法
 **/
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                //如果遇到"）"弹出运算符和操作数，将计算结果压入栈中
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                if (op.equals("-")) v = vals.pop() - v;
                if (op.equals("*")) v = vals.pop() * v;
                if (op.equals("/")) v = vals.pop() / v;
                if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
                //结束标志
            }else if (s.equals("end")){
                break;
            }
            else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
