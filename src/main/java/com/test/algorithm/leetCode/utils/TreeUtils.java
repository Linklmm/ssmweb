package com.test.algorithm.leetCode.utils;

import com.alibaba.fastjson.JSON;
import com.test.algorithm.leetCode.pojo.TreeNode;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2020-11-08 09:53
 * @description: 树工具
 **/
@Slf4j
public class TreeUtils {

  public static TreeNode listToTreeNode(int[] valArray) {
    if (0 == valArray.length) {
      return null;
    }
    AtomicReference<TreeNode> root = new AtomicReference<>();
    Arrays.stream(valArray).forEach(value -> {
      root.set(putItem(value, root.get()));
    });
    return root.get();
  }

  public static TreeNode putItem(Integer val, TreeNode root) {
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

  public static void main(String[] args) {
    log.error("tree depth is {}",
        JSON.toJSONString(
            TreeUtils.listToTreeNode(new int[]{1, 2, 3, 0, 0, 1, 1, 1})));
  }
}
