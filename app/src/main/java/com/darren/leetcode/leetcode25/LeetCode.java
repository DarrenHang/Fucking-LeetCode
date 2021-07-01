package com.darren.leetcode.leetcode25;

/**
 * date  6/30/21  2:12 PM
 * author
 * K 个一组翻转链表
 */
class LeetCode {

    public static void main(String[] args) {
        reverseKGroup(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4)))),2);
    }

    //以 1 -> 2  -> 3 为例子
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode target = new ListNode(0, head);
        ListNode node = target;
        ListNode first = head;
        ListNode second = null;
        //长度
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        int size = length / k;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < k - 1; j++) {
                second = first.next;//2
                first.next = second.next;//1 -> 3
                second.next = node.next;//2 -> 1
                node.next = second;//0 -> 2
            }
            node = first;
            first = first.next;
        }

        return target.next;
    }

}
