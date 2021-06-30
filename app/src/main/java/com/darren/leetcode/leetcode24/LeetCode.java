package com.darren.leetcode.leetcode24;

/**
 * date  6/30/21  10:53 AM
 * author  DarrenHang
 * 两两交换链表中的节点
 */
class LeetCode {

    public static void main(String[] args) {
        ListNode node = swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        //如果链表为空或者头指针的next为空，则直接返回
        if (head == null || head.next == null) {
            return head;
        }
        //目标链表
        ListNode target = new ListNode(0, head);
        //临时链表
        ListNode node = target;
        //第一个指针
        ListNode first = head;
        //第二个指针
        ListNode second = null;
        while (first != null && first.next != null) {
            //设置第二个指针的位置
            second = first.next; // 2
            //将第一个指针指向第二个指针的next
            first.next = second.next;// 1 -> 3 -> 4
            //将第二个指针指向头节点
            second.next = first;//2 -> 1 -> 3
            node.next = second;// 0 -> 2 -> 1 -> 3 -> 4
            node = first;
            first = first.next;
        }

        return target.next;
    }

}
