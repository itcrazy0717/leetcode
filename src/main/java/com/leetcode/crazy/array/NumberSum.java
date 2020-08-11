package com.leetcode.crazy.array;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author: dengxin.chen
 * @date: 2018/12/13 14:29
 * @description: 两数之和
 */
public class NumberSum {

	/**
	 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	 * <p>
	 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
	 * <p>
	 * 示例:
	 * <p>
	 * 给定 nums = [2, 7, 11, 15], target = 9
	 * <p>
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9
	 * 所以返回 [0, 1]
	 * https://leetcode-cn.com/problems/two-sum/
	 */
	public static void main(String[] args) {

		int[] nums = {2, 5, 5, 15};
		int target = 20;
		int[] result = twoSum4(nums, target);
		for (int item : result) {
			System.out.println(item);
		}

	}

	/**
	 * 这种方法效率不是特别高
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum1(int[] nums, int target) {
		int[] position = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target && i != j) {
					position[0] = i;
					position[1] = j;
					return position;
				}
			}
		}
		return position;
	}

	/**
	 * 通过从后往前走的方式，效率稍微有提高
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum2(int[] nums, int target) {
		int[] position = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[i] + nums[j] == target) {
					position[0] = i;
					position[1] = j;
					return position;
				}
			}
		}
		return position;
	}

	public static int[] twoSum3(int[] nums, int target) {
		int[] position = new int[2];
		Map<Integer, Integer> map = Maps.newHashMap();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int tmp = target - nums[i];
			if (map.containsKey(tmp) && map.get(tmp) != i) {
				position[0] = i;
				position[1] = map.get(tmp);
				return position;
			}
		}
		return position;
	}

	public static int[] twoSum4(int[] nums, int target) {
		Map<Integer, Integer> map = Maps.newHashMap();
		for (int i = 0; i < nums.length; i++) {
			int tmp = target - nums[i];
			if (map.containsKey(tmp)) {
				return new int[]{map.get(tmp), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("no one");
	}

}
