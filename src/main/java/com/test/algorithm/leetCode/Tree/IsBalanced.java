package com.test.algorithm.leetCode.Tree;

import com.test.algorithm.leetCode.pojo.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-11 21:10
 * @description: 110. 平衡二叉树
 * 是否是一个平衡二叉树
 **/
public class IsBalanced {

  public static Map<TreeNode, Integer> treeMap = new HashMap<>();

  public boolean isBalanced(TreeNode root) {
    if (Objects.isNull(root)) {
      return true;
    }
    return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left)
        && isBalanced(root.right);
  }

  public static int depth(TreeNode root) {
    if (Objects.isNull(root)) {
      treeMap.put(root, 0);
      return 0;
    }
    if (Objects.isNull(treeMap.get(root))) {
      treeMap.put(root, Math.max(depth(root.right), depth(root.left)) + 1);
    }
    return treeMap.get(root);
  }
}
