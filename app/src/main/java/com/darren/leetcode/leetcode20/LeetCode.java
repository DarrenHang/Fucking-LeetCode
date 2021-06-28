package com.darren.leetcode.leetcode20;

import java.util.Stack;

/**
 * date  6/28/21  12:02 PM
 * author  DarrenHang
 * 有效的括号
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(isValid("}}{{"));
    }

    public static boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }

        if (s.startsWith(")") || s.startsWith("}") || s.startsWith("]")) {
            return false;
        }

        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.peek() != c) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
