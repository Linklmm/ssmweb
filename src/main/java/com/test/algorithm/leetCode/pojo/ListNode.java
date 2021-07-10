package com.test.algorithm.leetCode.pojo;


/**
 * Description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author playboy
 * @date 2020-07-05 17:02
 * version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode head;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void push(int val){
        ListNode oldNode = this.head;
        ListNode newNode = new ListNode(val);
        newNode.next = oldNode;
        this.head = newNode;
    }
}
