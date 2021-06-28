package com.darren.leetcode.leetcode19;

/**
 * date  6/28/21  10:48 AM
 * author  DarrenHang
 * 删除链表的倒数第 N 个结点
 */
class LeetCode {


    public static void main(String[] args) {

    }

    //暴力解法
    //解题思路
    //首先确定链表的长度
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode result = new ListNode(0, head);

        int length = getNodeLength(head);

        if (length == 0) {
            return result.next;
        }

        ListNode current = result;

        for (int i = 0; i < length - n; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        ListNode ans = result.next;
        return ans;
    }


    public static int getNodeLength(ListNode head) {
        int length = 0;

        if (head == null) {
            return length;
        }
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    //双指针
    public ListNode removeNthFromEnd_(ListNode head, int n) {
        ListNode result = new ListNode(0, head);
        if (head == null) {
            return result.next;
        }

        ListNode fast = head;
        ListNode slow = result;

        int start = 0;

        while (fast != null) {
            fast = fast.next;
            if (start >= n) {
                slow = slow.next;
            }
            start++;
        }

        slow.next = slow.next.next;

        ListNode ans = result.next;

        return ans;
    }

}
