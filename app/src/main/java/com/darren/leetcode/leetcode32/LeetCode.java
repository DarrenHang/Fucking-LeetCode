package com.darren.leetcode.leetcode32;

import java.util.Stack;

/**
 * date  7/9/21  3:09 PM
 * author  DarrenHang
 * 最长有效括号
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(((())))"));
    }

    public static int longestValidParentheses(String s) {
        //字符串长度
        int length = s.length();
        if (length < 2) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

}
