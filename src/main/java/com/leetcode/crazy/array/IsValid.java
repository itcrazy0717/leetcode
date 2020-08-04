package com.leetcode.crazy.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: dengxin.chen
 * @date: 2020-08-04 18:51
 * @description: 括号匹配
 */
public class IsValid {

	public static void main(String[] args) {
		System.out.println(isValid("([])"));
	}

	public static boolean isValid(String s) {
		if (s == null || s.length() % 2 != 0) {
			return false;
		}
		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				Character peek = stack.peek();
				if ((peek == '(' && c == ')') || (peek == '[' && c == ']') || (peek == '{' && c == '}')) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
