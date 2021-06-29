package com.darren.leetcode.leetcode22;

import java.util.ArrayList;
import java.util.List;

/**
 * date  6/28/21  4:00 PM
 * author  DarrenHang
 * 括号生成
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    //暴力破解
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 1) {
            list.add("()");
            return list;
        }
        generateAll(new char[n * 2], 0, list);
        return list;
    }

    private static void generateAll(char[] chars, int pos, List list) {
        if (pos == chars.length) {
            if (validate(chars)) {
                list.add(new String(chars));
            }
        } else {
            if (pos == 0) {
                chars[pos] = '(';
                generateAll(chars, pos + 1, list);
            } else if (pos == chars.length - 1) {
                chars[pos] = ')';
                generateAll(chars, pos + 1, list);
            } else {
                chars[pos] = '(';
                generateAll(chars, pos + 1, list);
                chars[pos] = ')';
                generateAll(chars, pos + 1, list);
            }
        }
    }

    private static boolean validate(char[] chars) {
        int balance = 0;
        for (char c : chars) {

            if (c == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                return false;
            }

        }
        return balance == 0;
    }

}
