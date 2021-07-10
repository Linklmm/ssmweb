package com.test.algorithm.leetCode.pojo;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-06-28 22:07
 * @description: 泛型的二叉树
 **/
public class TreeNodeType<T> {
    public T val;
    public TreeNodeType<T> left;
    public TreeNodeType<T> right;

    public TreeNodeType() {
    }

    public TreeNodeType(T val) {
        this.val = val;
    }

    public TreeNodeType(T val, TreeNodeType<T> left, TreeNodeType<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
