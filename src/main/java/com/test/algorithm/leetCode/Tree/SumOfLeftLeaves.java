package com.test.algorithm.leetCode.Tree;

import com.test.algorithm.leetCode.pojo.TreeNode;
import java.util.Objects;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-12-19 20:59
 * @description: 404：左叶子之和
 **/
public class SumOfLeftLeaves {

  public static int sumOfLeftLeaves(TreeNode root) {
    int sum = 0;
    if (Objects.isNull(root)) {
      return 0;
    }
    //叶子节点，左右都为null
    //左节点处理
    TreeNode left = root.left;
    if (Objects.nonNull(left)) {
      //是否为叶子节点，是的话就+
      if (Objects.isNull(left.left) && Objects.isNull(left.right)) {
        sum += left.val;
      }else {
        sum += sumOfLeftLeaves(left);
      }
    }
    //右节点处理
    if (Objects.nonNull(root.right)) {
      sum += sumOfLeftLeaves(root.right);
    }
    return sum;
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    left.left = new TreeNode(4);
    left.right = new TreeNode(5);
    root.left = left;
    root.right = right;
    System.out.println(sumOfLeftLeaves(root));
  }

}
