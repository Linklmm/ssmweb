package com.test.algorithm.leetCode.pojo;

import apple.laf.JRSUIUtils.Tree;
import com.test.algorithm.leetCode.utils.TreeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.util.CollectionUtils;

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
    List<Integer> valList = new ArrayList<>();
    Arrays.stream(valArray).forEach(valList::add);
    TreeNode root = new TreeNode(valList.get(0));
    valList.remove(0);
    toTreeNode(valList, root);
    while (!CollectionUtils.isEmpty(valList)) {
      toTreeNode(valList, root.left);
      toTreeNode(valList, root.right);
    }
    return toTreeNode(valList, root);
  }

  public TreeNode toTreeNode(List<Integer> valList, TreeNode root) {
    if (CollectionUtils.isEmpty(valList)) {
      return null;
    }
    setLeft(valList, root);
    if (CollectionUtils.isEmpty(valList)) {
      return root;
    }
    setRight(valList, root);
    if (!CollectionUtils.isEmpty(valList)){
      toTreeNode(valList,root.left);
      toTreeNode(valList,root.right);
    }
    return root;
  }

  private void setRight(List<Integer> valList, TreeNode root) {
    TreeNode right = new TreeNode(valList.get(0));
    valList.remove(0);
    root.right = right;
  }

  private void setLeft(List<Integer> valList, TreeNode root) {
    TreeNode left = new TreeNode(valList.get(0));
    valList.remove(0);
    root.left = left;
  }

}
