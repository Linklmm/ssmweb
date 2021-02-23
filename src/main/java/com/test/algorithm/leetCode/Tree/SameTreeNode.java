package com.test.algorithm.leetCode.Tree;

import com.test.algorithm.leetCode.pojo.TreeNode;

/**
 * 相同的数
 */
public class SameTreeNode {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //不为空，进行判断，为空说明判断结束
        if (p != null && q != null) {
            if (p.val == q.val) {
                TreeNode leftP = p.left;
                TreeNode rightP = p.right;
                TreeNode leftQ = q.left;
                TreeNode rightQ = q.right;
                boolean left = false;
                boolean right = false;
                left = isSameTree(leftP, leftQ);
                right = isSameTree(rightP, rightQ);
                return left && right;
            }
        }
        if (null == p && null == q) {
            return true;
        } else {
            return false;
        }
    }

}
