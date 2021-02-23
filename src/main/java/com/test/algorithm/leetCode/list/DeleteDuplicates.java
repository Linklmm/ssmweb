package com.test.algorithm.leetCode.list;


import com.alibaba.fastjson.JSON;
import com.test.algorithm.leetCode.pojo.ListNode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Description 83. 删除排序链表中的重复元素
 *
 * @author playboy
 * @date 2020-07-12 11:19
 * version 1.0
 */
public class DeleteDuplicates {
    /***
     * 用treeMap去重
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        //用hashmap去重
        Map<Integer, Integer> map = new TreeMap<>();
        ListNode result = new ListNode(0);
        ListNode re = result;
        ListNode node = head;
        while (null != node) {
            map.put(node.val, null);
            node = node.next;
        }
        for (Integer num : map.keySet()) {
            ListNode listNode = new ListNode(num);
            re.next = listNode;
            re = re.next;
        }
        return result.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode result = head;
        ListNode next = head.next;
        while (null != result) {
            //下个元素相等则直接删掉当前元素
            if (result.next != null && result.val == result.next.val) {
                result.next = null;
                result = next;
                next = next.next;
                result = result.next;
            }
            result = result.next;
            next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listnode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        listNode.next = listnode2;
        listnode2.next = listNode3;

        DeleteDuplicates duplicates = new DeleteDuplicates();
        //System.out.println(JSON.toJSONString(duplicates.deleteDuplicates(listNode)));

        System.out.println(JSON.toJSONString(duplicates.deleteDuplicates2(listNode)));

    }

}
