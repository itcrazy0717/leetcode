package com.leetcode.crazy.array;

/**
 * @author: dengxin.chen
 * @date: 2020-07-31 15:40
 * @description:
 */
public class MaxArea {

	/**
	 * 盛水最多的容器，有点类似于木桶原理，最小最大
	 */

	public static void main(String[] args) {
		int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int maxResult = 0;
		while (left < right) {
			// 盛水容量是以最小的边来确定的
			int area = Math.min(height[left], height[right]) * (right - left);
			maxResult = Math.max(maxResult, area);
			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxResult;
	}

}
