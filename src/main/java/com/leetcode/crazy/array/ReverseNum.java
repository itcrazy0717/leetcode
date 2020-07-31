package com.leetcode.crazy.array;

/**
 * @author: dengxin.chen
 * @date: 2018/12/13 15:29
 * @description:反转整数
 */
public class ReverseNum {

	/**
	 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
	 */

	public static void main(String[] args) {

		System.out.println(reverse1(120));

	}

	/**
	 * 使用字符串的方法空间复杂度太高
	 *
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		try {
			String minus = "";
			if (x < 0) {
				minus = "-";
				x = -x;
			}
			StringBuilder sb = new StringBuilder(String.valueOf(x));
			String tmp = sb.reverse().toString();
			tmp = minus + tmp;
			Integer integer = Integer.valueOf(tmp);

			return integer;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	public static int reverse1(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			// 注意溢出判断，主要是根据rev * 10 + pop进行判断，包括正负
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
				return 0;
			}
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
				return 0;
			}
			rev = rev * 10 + pop;
		}
		return rev;
	}
}
