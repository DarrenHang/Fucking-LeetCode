package com.darren.leetcode.leetcode21;


/**
 * date  6/28/21  1:38 PM
 * author  DarrenHang
 * 合并两个有序链表
 */
class LeetCode {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = mergeTwoLists(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = new ListNode(0);
        ListNode next = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                next.next = l1;
                next = next.next;
                l1 = l1.next;
            } else {
                next.next = l2;
                next = next.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            next.next = l2;
        } else {
            next.next = l1;
        }

        return node.next;
    }

}
