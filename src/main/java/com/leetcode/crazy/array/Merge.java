package com.leetcode.crazy.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author: dengxin.chen
 * @date: 2020-08-06 18:53
 * @description:数组合并
 */
public class Merge {

	/**
	 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
	 * <p>
	 * 说明:
	 * <p>
	 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
	 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
	 * <p>
	 * 示例:
	 * <p>
	 * 输入:
	 * nums1 = [1,2,3,0,0,0], m = 3
	 * nums2 = [2,5,6],       n = 3
	 * <p>
	 * 输出: [1,2,2,3,5,6]
	 */

	/**
	 * 暴力方法
	 *
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
	}

	/**
	 * 双指针方法
	 *
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int[] tmp = new int[m];
		System.arraycopy(nums1, 0, tmp, 0, m);

		int p1 = 0, p2 = 0, p = 0;
		while (p1 < m && p2 < n) {
			nums1[p++] = tmp[p1] < nums2[p2] ? tmp[p1++] : nums2[p2++];
		}

		// nums1 还有剩余
		if (p1 < m) {
			System.arraycopy(tmp, p1, nums1, p1 + p2, m + n - p1 - p2);
		}
		if (p2 < n) {
			System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
		}
	}

	/**
	 * 双指针从后往前
	 *
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge3(int[] nums1, int m, int[] nums2, int n) {
		int p = m + n - 1;
		int p1 = m - 1;
		int p2 = n - 1;
		while (p1 >= 0 && p2 >= 0) {
			nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
		}
		// 拷贝缺失的，因为从后往前，所以这里要从前往后拷贝，因为已经有顺序
		System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	}
}
