package com.test.algorithm.leetCode.Tree;

import com.alibaba.fastjson.JSON;
import com.test.algorithm.leetCode.pojo.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-12-20 22:21
 * @description: 501. 二叉搜索树中的众数
 **/
public class FindMode {

  public static int[] findMode(TreeNode root) {
    if (Objects.isNull(root)) {
      return null;
    }
    Map<Integer, Integer> valMap = new HashMap<>();
    getValMap(root, valMap);
    List<Integer> maxKeys = new ArrayList<>();
    Integer max = 0;
    for (Integer key : valMap.keySet()) {
      if (valMap.get(key) > max) {
        max = valMap.get(key);
      }
    }
    for (Integer key : valMap.keySet()) {
      if (max.equals(valMap.get(key))) {
        maxKeys.add(key);
      }
    }
//    return maxKeys.toArray(new Integer[maxKeys.size()]);
    int[] result = new int[maxKeys.size()];
    for (int i = 0;i<maxKeys.size();i++){
      result[i] = maxKeys.get(i);
    }
    return result;
  }

  public static Map<Integer, Integer> getValMap(TreeNode root, Map<Integer, Integer> valMap) {
    if (Objects.isNull(root)) {
      return valMap;
    }
    if (Objects.nonNull(valMap.get(root.val))) {
      Integer count = valMap.get(root.val);
      valMap.put(root.val, ++count);
    } else {
      Integer count = 0;
      valMap.put(root.val, count);
    }
    getValMap(root.left, valMap);
    getValMap(root.right, valMap);
    return valMap;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    System.out.println(JSON.toJSONString(findMode(root)));
  }
}
