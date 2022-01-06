package com.test.algorithm.leetCode.Tree;

import com.test.algorithm.leetCode.pojo.TreeNode;
import java.util.Objects;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-05 22:24
 * @description: 543. 二叉树的直径
 **/
public class DiameterOfBinaryTree {

  private static int result;

  public static int diameterOfBinaryTree(TreeNode root) {
    result = 0;
    depth(root);
    return result;
  }

  public static int depth(TreeNode root) {
    if (Objects.isNull(root)) {
      return 0;
    }
    int lDepth = depth(root.left);
    int rDepth = depth(root.right);
    result = Math.max(result, lDepth + rDepth);
    return Math.max(lDepth, rDepth) + 1;
  }

}
