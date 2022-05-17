package com.test.algorithm.leetCode.Tree;

import com.test.algorithm.leetCode.pojo.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-12-13 21:49
 * @description: 112.路径总和
 **/
public class HasPathSum {

  public static boolean hasPathSum(TreeNode root, int targetSum) {
    //空树返回空
    if (Objects.isNull(root)) {
      return false;
    }
    int sum = 0;
    List<Integer> sums = new ArrayList<>();
    nodeSum(root, sums, sum);
//    Optional<Integer> sumOptional = sums.stream().filter(s -> s == targetSum).findAny();
//    return sumOptional.isPresent();
    for (int i = 0; i < sums.size(); i++) {
      if (targetSum == sums.get(i)) {
        return true;
      }
    }
    return false;
  }

  public static void nodeSum(TreeNode node, List<Integer> sums, Integer sum) {
    if (Objects.nonNull(node)) {
      sum += node.val;
      if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
        sums.add(sum);
      }
      if (Objects.nonNull(node.left)) {
        nodeSum(node.left, sums, sum);
      }
      //右节点计算
      if (Objects.nonNull(node.right)) {
        nodeSum(node.right, sums, sum);
      }
    }
  }

  public static void main(String[] args) {
    TreeNode left = new TreeNode();
    left.val = 2;
    TreeNode right = new TreeNode();
    right.val = 3;
    TreeNode root = new TreeNode(1, left, right);
    System.out.println(hasPathSum(root, 3));
  }

}
