package com.test.algorithm.leetCode.list;


import com.alibaba.fastjson.JSON;
import com.test.algorithm.leetCode.pojo.ListNode;
import java.util.List;

/**
 * Description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author playboy
 * @date 2020-07-05 17:00
 * version 1.0
 */
public class MergeTwoLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//最终值
		ListNode endNode = new ListNode(0);
		ListNode head = endNode;
		while (l1!=null&&l2!=null){
			if (l1.val<l2.val){
				head.next = new ListNode(l1.val);
				l1 = l1.next;
			}else {
				head.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			head = head.next;
		}
		if (l1!=null) head.next = l1;
		if (l2!=null) head.next = l2;
		return endNode.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
		ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
		System.out.println(JSON.toJSONString(mergeTwoLists(l1, l2)));
	}

}
