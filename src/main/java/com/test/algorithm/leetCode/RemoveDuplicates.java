package com.test.algorithm.leetCode;


import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @author playboy
 * @date 2020-07-06 08:21
 * version 1.0
 */
public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		//用hashMap的 key 进行去重
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], null);
			nums[i] = 0;
		}
		int j = 0;
		for (Integer key : map.keySet()) {
			nums[j] = key;
			j++;
		}
		return map.keySet().size();

	}

	public static void main(String[] args) {
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		System.out.println(removeDuplicates.removeDuplicates(nums));
		System.out.println(JSON.toJSONString(nums));
	}

}
