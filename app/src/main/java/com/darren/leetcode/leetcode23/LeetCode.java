package com.darren.leetcode.leetcode23;


/**
 * date  6/29/21  4:32 PM
 * author  DarrenHang
 * 合并K个升序链表
 */
class LeetCode {

    public static void main(String[] args) {
        mergeKLists(new ListNode[]{});
    }

    //暴力破解
    //便利所有的链表
    public static ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;

        ListNode result = null;

        if (length == 0) {
            return result;
        }

        for (int i = 0; i < length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }

        return result;
    }

    //21题，合并2个有序数组
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
