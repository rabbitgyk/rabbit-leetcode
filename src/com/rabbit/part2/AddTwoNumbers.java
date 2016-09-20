package com.rabbit.part2;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author rabbit 2016年9月20日
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		// 把相加后的结果存放于链表1，pre1是用于最后有进位时在其后new新结点
		ListNode ret = l1;
		ListNode pre1 = new ListNode(0);
		pre1.next = l1;

		int flag = 0;
		while (l1 != null && l2 != null) {
			l1.val = l1.val + l2.val + flag;
			flag = l1.val / 10;
			l1.val = l1.val % 10;
			pre1 = l1;
			l1 = l1.next;
			l2 = l2.next;
		}

		// 如果链表2有剩余，接到链表1的后面
		if (l2 != null) {
			pre1.next = l2;
			l1 = l2;
		}

		while (l1 != null) {
			l1.val += flag;
			flag = l1.val / 10;
			l1.val = l1.val % 10;
			pre1 = l1;
			l1 = l1.next;
		}

		if (flag > 0) {
			ListNode node = new ListNode(1);
			pre1.next = node;
		}

		return ret;
	}

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}