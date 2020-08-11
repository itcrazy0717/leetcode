package com.leetcode.crazy.array;

/**
 * @author: dengxin.chen
 * @date: 2020-08-03 11:16
 * @description:字符串相加，大数相加
 */
public class AddStrings {

	/**
	 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
	 * <p>
	 * 注意：
	 * <p>
	 * num1 和num2 的长度都小于 5100.
	 * num1 和num2 都只包含数字 0-9.
	 * num1 和num2 都不包含任何前导零。
	 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
	 * https://leetcode-cn.com/problems/add-strings/
	 */

	public static void main(String[] args) {
		System.out.println(addStrings("123", "123"));
	}

	public static String addStrings(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int add = 0;
		StringBuilder ans = new StringBuilder();
		while (i >= 0 || j >= 0 || add != 0) {
			int x = i >= 0 ? num1.charAt(i) - '0' : 0;
			int y = j >= 0 ? num2.charAt(j) - '0' : 0;
			int tmp = x + y + add;
			ans.append(tmp % 10);
			add = tmp / 10;
			i--;
			j--;
		}
		// 这里必须翻转
		return ans.reverse().toString();
	}
}
