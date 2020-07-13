package com.test.algorithm.leetCode;


import java.util.ArrayList;
import java.util.List;

/**
 * Description 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author playboy
 * @date 2020-07-08 15:26
 * version 1.0
 */
public class MaxSubArray {
	public int maxSubArray(int[] nums) {
		int sum = 0;
		//假设最大值
		int ans = nums[0];
		if (nums.length == 1) {
			return nums[0];
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (sum > 0) {
					sum += nums[i];
				} else {
					//因为sum<0,所以即使后面数再打，也不可能比当前值大，
					// 所以直接总和直接从当前值开始，并以当前值为总和，并和之前的总和的值比较，看哪个大,
					// 记哪个
					sum = nums[i];
				}
				ans = Math.max(ans, sum);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		MaxSubArray maxSubArray = new MaxSubArray();
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubArray.maxSubArray(nums));
	}

}
