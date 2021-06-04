package com.darren.leetcode.leetcode2;

/**
 * date  4/1/21  4:18 PM
 * author  DarrenHang
 * 两数相加
 */
class LeetCode {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    //解题思路：新建链表，便利原链表，短链表位数不够用 0表示，累加当前两个链表的数值，用当前的值%10，大于10则进位，进入下一次的计算
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode node = result;
        //进位
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            //累加值
            int total = l1Val + l2Val + carry;
            //计算进位
            carry = total / 10;
            node.next = new ListNode(total % 10);
            node = node.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return result.next;
    }

}
