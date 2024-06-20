package com.leetcode.crazy.link;

/**
 * @author: dengxin.chen
 * @date: 2020-08-06 14:11
 * @description:合并链表
 */
public class MergeTwoLists {

	/**
	 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
	 * <p>
	 * 输入：1->2->4, 1->3->4
	 * 输出：1->1->2->3->4->4
	 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
	 */

	/**
	 * 递归方式
	 *
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			l1.next = mergeTwoLists1(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists1(l1, l2.next);
			return l2;
		}
	}

	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode prev = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		prev.next = (l1 == null) ? l2 : l1;
		return head.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
