package com.test.algorithm.leetCode;

import com.test.algorithm.leetCode.pojo.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 101.对称二叉树
 */
@Slf4j
public class IsSymmetric {
    public static boolean isSymmetric(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }

        if ((Objects.isNull(root.left) && Objects.isNull(root.right))) {
            return true;
        } else if (Objects.nonNull(root.left) && Objects.nonNull(root.right)) {
            return isSymmetric(root.left, root.right);
        }
        return false;
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left.val == right.val) {
            //都为空，直接返回
            if (null == left.left && null == left.right && null == right.left && null == right.right) {
                return true;
            } else if (Objects.nonNull(left.left) && Objects.nonNull(left.right)
                    && Objects.nonNull(right.left) && Objects.nonNull(right.right)) {
                //都不为空的情况
                if (left.left.val == right.right.val && left.right.val == right.left.val) {
                    boolean isLeftSymmetric = isSymmetric(left.left, right.right);
                    boolean isRightSymmetric = isSymmetric(left.right, right.left);
                    return isLeftSymmetric && isRightSymmetric;
                }
                return false;
            } else {
                boolean isLeftSymmetric = false;
                boolean isRightSymmetric = false;
                //有不为空的情况
                if (Objects.nonNull(left.left) && Objects.nonNull(right.right)) {
                    if (left.left.val == right.right.val) {
                        isLeftSymmetric = isSymmetric(left.left, right.right);
                    }
                }
                if (Objects.isNull(left.left) && Objects.isNull(right.right)){
                    isLeftSymmetric = true;
                }
                if (Objects.nonNull(left.right) && Objects.nonNull(right.left)) {
                    if (left.right.val == right.left.val) {
                        isRightSymmetric = isSymmetric(left.right, right.left);
                    }
                }
                if (Objects.isNull(left.right) && Objects.isNull(right.left)){
                    isRightSymmetric = true;
                }
                return isLeftSymmetric && isRightSymmetric;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);

        left.right = new TreeNode(3);
        right.left = new TreeNode(3);

        root.left = left;
        root.right = right;

        log.error(isSymmetric(root) + "");

//        TreeNode root2 = new TreeNode(1);
//        root2.left = new TreeNode(0);
//        log.error(isSymmetric(root2) + "");
    }
}
