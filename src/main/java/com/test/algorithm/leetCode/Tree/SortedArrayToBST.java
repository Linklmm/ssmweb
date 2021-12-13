package com.test.algorithm.leetCode.Tree;

import com.test.algorithm.leetCode.pojo.TreeNode;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-12 23:25
 * @description: 108. 将有序数组转换为二叉搜索树
 **/
public class SortedArrayToBST {

  public TreeNode sortedArrayToBST(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }

  public TreeNode helper(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = (left + right) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = helper(nums, left, mid - 1);
    root.right = helper(nums, mid + 1, right);
    return root;
  }

}
