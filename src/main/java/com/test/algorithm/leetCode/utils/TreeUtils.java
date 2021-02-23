package com.test.algorithm.leetCode.utils;

import com.test.algorithm.leetCode.pojo.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2020-11-08 09:53
 * @description: 树工具
 **/
@Slf4j
public class TreeUtils {
    /**
     * 数组转二叉树
     *
     * @param list
     * @return 二叉树
     */
    public static TreeNode arraysToBinaryTree(List<Integer> list) {
        if (null == list || list.size() == 0) {
            return null;
        }
        //得到树的深度
        int depth = getTreeDepth(list);
        TreeNode root = new TreeNode(list.get(0));
        return null;
    }


    /**
     * 得到数组转换为二叉树的深度
     *
     * @param list
     * @return
     */
    private static int getTreeDepth(List<Integer> list) {
        int size = list.size() + 1;
        int depthNum = 0;
        if (1 == list.size()) {
            return 1;
        }
        while (0 != size / 2 || 0 != size % 2) {
            int remainder = size % 2;
            size = size / 2 + remainder;
            depthNum++;
            if (1 == size && 0 == remainder) {
                return depthNum;
            }
        }
        return depthNum;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 0, 0, 1, 1, 1);
        log.error("tree depth is {}", getTreeDepth(list));
    }
}
