package com.test.algorithm.leetCode;

import com.alibaba.fastjson.JSON;

/**
 * @author link.liu
 * @version 1.0.0
 * @className MergeTwoSortArray.java
 * @description 合并两个有序数组
 * @createTime 2020年08月17日 17:10:00
 */
public class MergeTwoSortArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums2[i] <= nums1[j]) {
                    System.arraycopy(nums1, j, nums1, j + 1, nums1.length - 1 - j);
                    nums1[j] = nums2[i];
                    j++;
                    break;
                }
                //比 nums1 任何值都大
                if (j == nums1.length - 1) {
                    nums1[m + i] = nums2[i];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        MergeTwoSortArray mergeTwoSortArray = new MergeTwoSortArray();
        mergeTwoSortArray.merge(nums1, 3, nums2, 3);
        System.out.println(JSON.toJSONString(nums1));
    }
}
