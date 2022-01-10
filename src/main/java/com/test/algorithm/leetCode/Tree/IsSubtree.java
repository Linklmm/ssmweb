package com.test.algorithm.leetCode.Tree;

import com.test.algorithm.leetCode.pojo.TreeNode;
import java.util.Objects;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-01-06 22:08
 * @description: 572. 另一棵树的子树
 **/
public class IsSubtree {

  public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
    return subtreeFlag(root, subRoot, 0);
  }

  public static boolean subtreeFlag(TreeNode root, TreeNode subRoot, int i) {
    if (Objects.isNull(root) && Objects.isNull(subRoot)) {
      return true;
    }
    //sub 不为null
    if (Objects.isNull(root)) {
      return false;
    }
    if (Objects.isNull(subRoot)) {
      return false;
    }
    if (root.val == subRoot.val) {
      boolean subLTreeFlag = subtreeFlag(root.left, subRoot.left, 1);
      boolean subRTreeFlag = subtreeFlag(root.right, subRoot.right, 1);
      if (subLTreeFlag && subRTreeFlag) {
        return true;
      }
    }
    if (i == 1) {
      return false;
    }
    //左节点判断
    boolean lSubFlag = subtreeFlag(root.left, subRoot, 0);
    boolean rSubFlag = subtreeFlag(root.right, subRoot, 0);
    if (lSubFlag || rSubFlag) {
      return true;
    }
    return false;
  }
}
