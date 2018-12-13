package com.leetcode.start01;

/**
 * @author: dengxin.chen
 * @date: 2018/12/13 15:29
 * @description:反转整数
 */
public class ReverseNum {

    public static void main(String[] args) {

        System.out.println(reverse(120));

    }

    public static int reverse(int x) {
        try {
            String minus = "";
            if (x < 0) {
                minus = "-";
                x = -x;
            }
            StringBuffer sb = new StringBuffer(String.valueOf(x));
            String tmp = sb.reverse().toString();
            tmp = minus + tmp;
            Integer integer = Integer.valueOf(tmp);

            return integer.intValue();
        } catch (IllegalArgumentException e) {
            return 0;
        }
    }
}
