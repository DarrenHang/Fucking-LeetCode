package com.darren.leetcode.leetcode9;

/**
 * date  6/22/21  11:14 AM
 * author  DarrenHang
 * 回文数
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome_(121));
    }

    //思路一
    //将数字转换成字符串，然后判断字符串是否回文
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        //转换成字符串
        String str = Integer.toString(x);
        char[] chars = str.toCharArray();
        //获取字符串的长度
        int length = chars.length;
        //中心
        int center = length / 2;
        for (int i = 0; i < center; i++) {
            if (chars[i] != chars[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    //优化：不将整数转换为字符串
    //思路：如果为负数或者%10为0则不是回文
    public static boolean isPalindrome_(int x) {
        //为0返回true
        if (x == 0) {
            return true;
        }
        //为负数或者%10为0返回 false
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int result = 0;
        int v = x;
        while (v != 0) {
            result = result * 10 + v % 10;
            v = v / 10;
        }
        return result == x;
    }

}
