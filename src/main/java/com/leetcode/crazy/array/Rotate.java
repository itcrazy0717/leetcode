package com.leetcode.crazy.array;

/**
 * @author: dengxin.chen
 * @date: 2020-08-05 17:04
 * @description: 旋转数据
 */
public class Rotate {

	/**
	 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
	 * 示例 1:
	 * 输入: [1,2,3,4,5,6,7] 和 k = 3
	 * 输出: [5,6,7,1,2,3,4]
	 * 解释:
	 * 向右旋转 1 步: [7,1,2,3,4,5,6]
	 * 向右旋转 2 步: [6,7,1,2,3,4,5]
	 * 向右旋转 3 步: [5,6,7,1,2,3,4]
	 * https://leetcode-cn.com/problems/rotate-array/
	 */

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		rotate3(nums, 3);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

	/**
	 * 暴力方法
	 *
	 * @param nums
	 * @param k
	 */
	public static void rotate1(int[] nums, int k) {
		if (k == 0) {
			return;
		}
		for (int i = 0; i < k % nums.length; i++) {
			int prev = nums[nums.length - 1];
			for (int j = 0; j < nums.length; j++) {
				int tmp = nums[j];
				nums[j] = prev;
				prev = tmp;
			}
		}
	}

	/**
	 * 使用一个额外的数组进行操作
	 *
	 * @param nums
	 * @param k
	 */
	public static void rotate2(int[] nums, int k) {
		int[] tmp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			tmp[(i + k) % nums.length] = nums[i];
		}
		for (int j = 0; j < nums.length; j++) {
			nums[j] = tmp[j];
		}
	}

	/**
	 * 进行反转
	 *
	 * @param nums
	 * @param k
	 */
	public static void rotate3(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int tmp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = tmp;
		}
	}


}
