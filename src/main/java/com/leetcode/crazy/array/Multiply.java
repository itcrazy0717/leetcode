package com.leetcode.crazy.array;

/**
 * @author: dengxin.chen
 * @date: 2020-08-17 14:34
 * @description:字符串相乘
 */
public class Multiply {

	/**
	 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: num1 = "2", num2 = "3"
	 * 输出: "6"
	 * 示例2:
	 * <p>
	 * 输入: num1 = "123", num2 = "456"
	 * 输出: "56088"
	 * 说明：
	 * <p>
	 * num1和num2的长度小于110。
	 * num1 和num2 只包含数字0-9。
	 * num1 和num2均不以零开头，除非是数字 0 本身。
	 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
	 * <p>
	 * 链接：https://leetcode-cn.com/problems/multiply-strings
	 */

	public static void main(String[] args) {
		System.out.println(multiply1("123", "456"));
	}

	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		String ans = "0";
		// 被乘数
		int n1 = num1.length() - 1;
		// 乘数
		int n2 = num2.length() - 1;
		// 循环乘数的个数
		for (int i = n2; i >= 0; i--) {
			StringBuilder sb = new StringBuilder();
			int add = 0;
			// 补零
			for (int j = n2; j > i; j--) {
				sb.append(0);
			}
			int y = num2.charAt(i) - '0';
			// 与被乘数相乘
			for (int j = n1; j >= 0; j--) {
				int x = num1.charAt(j) - '0';
				int tmp = x * y + add;
				sb.append(tmp % 10);
				add = tmp / 10;
			}
			// 进位
			if (add != 0) {
				sb.append(add % 10);
			}
			// 注意传参反转
			ans = addString(ans, sb.reverse().toString());
		}
		return ans;
	}

	public static String addString(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int add = 0;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0 || add != 0) {
			int x = i >= 0 ? num1.charAt(i) - '0' : 0;
			int y = j >= 0 ? num2.charAt(j) - '0' : 0;
			int tmp = x + y + add;
			sb.append(tmp % 10);
			add = tmp / 10;
			i--;
			j--;
		}
		return sb.reverse().toString();
	}

	public static String multiply1(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int[] res = new int[num1.length() + num2.length()];
		// 循环被乘数
		for (int i = num1.length() - 1; i >= 0; i--) {
			int n1 = num1.charAt(i) - '0';
			// 循环乘数
			for (int j = num2.length() - 1; j >= 0; j--) {
				int n2 = num2.charAt(j) - '0';
				// 计算当前乘积的总和
				int sum = res[i + j + 1] + n1 * n2;
				res[i + j + 1] = sum % 10;
				res[i + j] += sum / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			if (i == 0 && res[i] == 0) {
				continue;
			}
			sb.append(res[i]);
		}
		return sb.toString();
	}
}
