package com.darren.leetcode.leetcode5;

/**
 * date  6/4/21  10:05 AM
 * author  DarrenHang
 * 最长回文子串
 */
class LeetCode {


    public static void main(String[] args) {
        String str = longestPalindrome("babadab");
        System.out.println(str);
    }

    //暴力破解
    public static String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        //获取字符串长度
        int length = s.length();
        //长度为1直接返回
        if (length < 2) {
            return s;
        }
        //最长回文子串的长度
        int strLength = 0;
        //记录最终索引
        int finalIndex = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isReBack(str, i, j)) {
                    int newLength = j - i;
                    if (newLength > strLength) {
                        strLength = newLength;
                        finalIndex = i;
                    }
                }
            }
        }

        return s.substring(finalIndex, finalIndex + strLength + 1);
    }

    //判断字符串是否回文
    public static Boolean isReBack(char[] str, int start, int end) {
        //字符串的长度
        int length = end - start;
        //字符串的中心点
        int center = length / 2;
        //从左右向中心便利
        for (int i = start, j = end; i <= center + start; i++, j--) {
            if (str[i] != str[j]) {
                return false;
            }
        }
        return true;
    }

}
