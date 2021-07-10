package com.test.algorithm.leetCode.list;

import com.alibaba.fastjson.JSON;
import com.test.algorithm.leetCode.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-04 23:02
 * @description: 反转链表
 **/
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if (Objects.isNull(head)) {
            return new ListNode();
        }
        List<Integer> list = new ArrayList<>();
        while (Objects.nonNull(head)) {
            list.add(head.val);
            head = head.next;
        }
        ListNode reverseList = new ListNode(list.get(list.size()-1));
        for (int i = list.size() - 2; i >= 0; i--) {
            ListNode oldNode = reverseList;
            reverseList = new ListNode(list.get(i));
            reverseList.next = oldNode;
        }
        return reverseList;
    }

    /**
     * 尾插法
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head){
        if (Objects.isNull(head)){
            return new ListNode();
        }
        ListNode reverseNode = new ListNode(head.val);
        head = head.next;
        while (Objects.nonNull(head)){
            ListNode oldNode = reverseNode;
            reverseNode = new ListNode(head.val);
            reverseNode.next = oldNode;
            head = head.next;
        }
        return reverseNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        for (int i = 1; i <= 5; i++) {
            listNode.push(i);
        }
        System.out.println(JSON.toJSON(reverseList(listNode.head)));
        System.out.println(JSON.toJSON(reverseList1(listNode.head)));
    }
}
