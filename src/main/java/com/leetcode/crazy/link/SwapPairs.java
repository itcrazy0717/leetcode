package com.leetcode.crazy.link;

/**
 * @author: dengxin.chen
 * @date: 2020-08-11 19:09
 * @description:两两交换链表的节点
 */
public class SwapPairs {

	/**
	 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
	 * <p>
	 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
	 * 
	 * 示例:
	 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
	 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
	 */
	/**
	 * 递归方法
	 *
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode firstNode = head;
		ListNode secondNode = head.next;
		firstNode.next = swapPairs(secondNode.next);
		secondNode.next = firstNode;
		return secondNode;
	}


	/**
	 * 迭代方法
	 *
	 * @param head
	 * @return
	 */
	public ListNode swapPairs1(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		while (head != null && head.next != null) {

			ListNode firstNode = head;
			ListNode secondNode = head.next;

			// swap
			prev.next = secondNode;
			firstNode.next = secondNode.next;
			secondNode.next = firstNode;

			prev = firstNode;
			head = firstNode.next;
		}
		return dummy.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
