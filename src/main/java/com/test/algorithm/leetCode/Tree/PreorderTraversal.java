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
 * @create: 2021-07-14 23:31
 * @description: 二叉树前序遍历 根节点——左子树——右子树
 **/
public class PreorderTraversal {

  /**
   * 递归解决方案
   *
   * @param root
   * @return
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (null != root) {
      result.add(root.val);
      List<Integer> lefts = preorderTraversal(root.left);
      List<Integer> rights = preorderTraversal(root.right);
      result.addAll(lefts);
      result.addAll(rights);
    }
    return result;
  }

  /**
   * 迭代
   *
   * @param root
   * @return
   */
  public List<Integer> preorderTraversal2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stk = new LinkedList<>();
    while (Objects.nonNull(root) || !stk.isEmpty()) {
      while (Objects.nonNull(root)) {
        res.add(root.val);
        stk.push(root);
        root = root.left;
      }
      root = stk.pop();
      root = root.right;
    }
    return res;
  }
}
