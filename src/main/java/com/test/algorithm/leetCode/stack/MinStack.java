package com.test.algorithm.leetCode.stack;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-01 21:34
 * @description: 155、最小栈
 **/
public class MinStack {
    /**
     * 数组实现栈
     */
    private List<Integer> stack;

    /**
     * 栈中最小元素
     */
    private Integer minItem;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        getMInStack();
    }

    private void getMInStack() {
        Optional<Integer> minOptional = stack.stream().min(Integer::compareTo);
        minOptional.ifPresent(integer -> minItem = integer);
    }

    public void pop() {
        if (!CollectionUtils.isEmpty(stack)) {
            stack.remove(stack.size() - 1);
            getMInStack();
        }
    }

    public int top() {
        Integer result = 0;
        if (!CollectionUtils.isEmpty(stack)) {
            result = stack.remove(stack.size() - 1);
            getMInStack();
        }
        return result;
    }

    public int getMin() {
        return minItem;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
    }
}
