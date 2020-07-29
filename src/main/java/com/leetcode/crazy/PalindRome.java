package com.leetcode.crazy;

/**
 * @author: dengxin.chen
 * @date: 2018/12/14 9:33
 * @description: 回文
 */
public class PalindRome {

    public static void main(String[] args) {

        System.out.println(isPalindrome1(121));
    }

    /**
     * 这种方式的效率不高
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String integerString = String.valueOf(x);
        StringBuilder sb = new StringBuilder(integerString);
        String palindromeString = sb.reverse().toString();
        return integerString.equals(palindromeString);
    }

    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        String palindromeString = sb.reverse().toString();
        try {
            int tmp = Integer.parseInt(palindromeString);
            return x == tmp;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
