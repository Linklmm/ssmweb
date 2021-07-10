package com.test.algorithm.leetCode.list;

import com.test.algorithm.leetCode.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-06-30 22:52
 * @description: 是否闭环
 **/
public class HasCycle {
    /**
     * hash表法
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (!nodeSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode rootNode = new ListNode(3);
        ListNode secondNode = new ListNode(2);
        ListNode threeNode = new ListNode(0);
        ListNode fourthNode = new ListNode(-4);
        rootNode.next = secondNode;
        secondNode.next = threeNode;
        threeNode.next = fourthNode;
        fourthNode.next = secondNode;
//        System.out.println(JSON.toJSON(rootNode));

        System.out.println(hasCycle(rootNode));
        System.out.println(hasCycle2(rootNode));
    }
}
