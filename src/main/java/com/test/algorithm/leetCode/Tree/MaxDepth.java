package com.test.algorithm.leetCode.Tree;

import com.test.algorithm.leetCode.pojo.TreeNode;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2020-11-08 09:41
 * @description: 104.二叉树的最大深度
 **/
public class MaxDepth {
    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }

    public static void main(String[] args) {

    }
}
