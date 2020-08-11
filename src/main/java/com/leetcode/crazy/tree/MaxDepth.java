package com.leetcode.crazy.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: dengxin.chen
 * @date: 2020-07-28 19:49
 * @description:
 */
public class MaxDepth {

	/**
	 * 给定一个二叉树，找出其最大深度。
	 * <p>
	 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
	 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
	 */
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 递归方式

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			/**
			 * 1 先计算左子树
			 * 2 再计算右子树
			 * 3 取两者的最大值+1
			 * 4 递归实现
			 */
			int leftDepth = maxDepth(root.left);
			int rightDepth = maxDepth(root.right);
			return Math.max(leftDepth, rightDepth) + 1;
		}
	}

	// bfs方式，对每层进行计算
	public int maxDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.push(root);
		int count = 0;
		while (!deque.isEmpty()) {
			// 每一层个数
			int size = deque.size();
			while (size-- > 0) {
				TreeNode current = deque.pop();
				if (current.left != null) {
					deque.addLast(current.left);
				}
				if (current.right != null) {
					deque.addLast(current.right);
				}
			}
			count++;
		}
		return count;
	}
}
