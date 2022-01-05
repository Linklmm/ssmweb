package com.test.algorithm.leetCode.Tree;

import com.alibaba.fastjson.JSON;
import com.test.algorithm.leetCode.pojo.TreeNode;
import java.util.Objects;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-12-22 22:29
 * @description: 530. 二叉搜索树的最小绝对差
 **/
public class GetMinimumDifference {

  public static int getMinimumDifference(TreeNode root) {
    int min = Integer.MAX_VALUE;
    if (Objects.isNull(root)) {
      return min;
    }
    //得到左节点的最小差值
    if (Objects.nonNull(root.left)) {
      min = getSubNodeMin(root, root.left);
      min = Math.min(min, getMinimumDifference(root.left));
    }
    if (Objects.nonNull(root.right)) {
      min = Math.min(min, getSubNodeMin(root, root.right));
      min = Math.min(min, getMinimumDifference(root.right));
    }
    if (Objects.nonNull(root.left) && Objects.nonNull(root.right)) {
      min = Math.min(min, Math.abs(root.left.val - root.right.val));
    }
    return min;
  }

  public static int getSubNodeMin(TreeNode root, TreeNode subNode) {
    int min = Integer.MAX_VALUE;
    if (Objects.isNull(root)) {
      return min;
    }
    if (Objects.nonNull(subNode)) {
      min = Math.abs(root.val - subNode.val);
      min = Math.min(min, getSubNodeMin(root, subNode.left));
      min = Math.min(min, getSubNodeMin(root, subNode.right));
    }
    return min;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    System.out.println(getMinimumDifference(root));

    TreeNode treeNode = new TreeNode();
    int[] val = new int[]{4, 2, 6, 1, 3,0,1};
    treeNode = treeNode.listToTreeNode(val);
    System.out.println(JSON.toJSONString(treeNode));
  }

}
