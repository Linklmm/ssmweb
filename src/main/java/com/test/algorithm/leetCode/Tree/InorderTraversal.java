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
 * @create: 2021-06-28 21:54
 * @description: 二叉树中序遍历，不使用递归的方式
 * 左子树——根节点——右子树
 **/
public class InorderTraversal {

  public static void inorder(TreeNode treeNode, List<Integer> res) {
    if (Objects.isNull(treeNode)) {
      return;
    }
    inorder(treeNode.left, res);
    res.add(treeNode.val);
    inorder(treeNode.right, res);
  }

  /**
   * 递归解决方法
   *
   * @param treeNode
   * @return
   */
  public static List<Integer> inorderTraversal(TreeNode treeNode) {
    List<Integer> res = new ArrayList<>();
    inorder(treeNode, res);
    return res;
  }

  /**
   * 递归变种，自己写的
   * @param root
   * @return
   */
  public static List<Integer> inorderTraversal3(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (Objects.isNull(root)) {
      return res;
    }
    List<Integer> left = inorderTraversal3(root.left);
    res.addAll(left);
    res.add(root.val);
    List<Integer> right = inorderTraversal3(root.right);
    res.addAll(right);
    return res;
  }

  /**
   * 迭代解决方法 使用栈解决
   *
   * @param root
   * @return
   */
  public static List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stk = new LinkedList<>();
    while (Objects.nonNull(root) || !stk.isEmpty()) {
      while (Objects.nonNull(root)) {
        stk.push(root);
        root = root.left;
      }
      root = stk.pop();
      res.add(root.val);
      root = root.right;
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(1);
    TreeNode left = new TreeNode();
    TreeNode right = new TreeNode(2);
    TreeNode node2 = new TreeNode(3);
    treeNode.left = left;
    treeNode.right = right;
    right.left = node2;
    System.out.println(inorderTraversal2(treeNode));

  }
}
