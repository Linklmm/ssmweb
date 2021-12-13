package com.test.algorithm.leetCode.Tree;

import com.test.algorithm.leetCode.pojo.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-14 22:06
 * @description: 145. 二叉树的后序遍历
 * 左子树-》右子树-》根节点
 **/
public class PostorderTraversal {

  /**
   * 后序遍历 迭代
   *
   * @param root
   * @return
   */
  public static List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) {
      return res;
    }

    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    TreeNode prev = null;
    while (Objects.nonNull(root) || !stack.isEmpty()) {
      while (Objects.nonNull(root)) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (Objects.isNull(root.right) || root.right == prev) {
        res.add(root.val);
        prev = root;
        root = null;
      } else {
        stack.push(root);
        root = root.right;
      }
    }
    return res;
  }

  /**
   * 递归
   *
   * @param root
   * @return
   */
  public static List<Integer> postorderTraversal2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (Objects.isNull(root)) {
      return res;
    }
    List<Integer> lefts = postorderTraversal2(root.left);
    List<Integer> rights = postorderTraversal2(root.right);
    res.addAll(lefts);
    res.addAll(rights);
    res.add(root.val);
    return res;
  }

}
