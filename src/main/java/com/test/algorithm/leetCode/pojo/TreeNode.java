package com.test.algorithm.leetCode.pojo;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {
  }

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

//    public int put(int item){
//
//    }

  public TreeNode listToTreeNode(int[] valArray) {
    if (0 == valArray.length) {
      return null;
    }
    AtomicReference<TreeNode> root = new AtomicReference<>();
    Arrays.stream(valArray).forEach(value ->
        root.set(putItem(value, root.get())));
    return root.get();
  }

  public TreeNode putItem(Integer val, TreeNode root) {
    if (Objects.isNull(root)) {
      root = new TreeNode(val);
    } else if (Objects.isNull(root.left)) {
      root.left = new TreeNode(val);
    } else if (Objects.isNull(root.right)) {
      root.right = new TreeNode(val);
    } else {
      //都有值，下个节点
      if (Objects.isNull(root.left.left) || Objects.isNull(root.left.right)) {
        putItem(val, root.left);
        return root;
      }
      if (Objects.isNull(root.right.left) || Objects.isNull(root.right.right)) {
        putItem(val, root.right);
        return root;
      }
    }

    return root;
  }

}
