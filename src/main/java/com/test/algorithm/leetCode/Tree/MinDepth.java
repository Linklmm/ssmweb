package com.test.algorithm.leetCode.Tree;

import com.test.algorithm.leetCode.pojo.TreeNode;
import java.util.Objects;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-08-20 16:21
 * @description: 111.最小树深度
 **/
public class MinDepth {

  public int minDepth(TreeNode root) {
    if (Objects.isNull(root)) {
      return 0;
    }
    if (Objects.isNull(root.left)&&Objects.nonNull(root.right)){
      return 1+minDepth(root.right);
    }
    if (Objects.nonNull(root.left)&&Objects.isNull(root.right)){
      return 1+minDepth(root.left);
    }
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }
}
