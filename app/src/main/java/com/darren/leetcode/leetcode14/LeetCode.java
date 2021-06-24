package com.darren.leetcode.leetcode14;

/**
 * date  6/24/21  11:50 AM
 * author  DarrenHang
 * 最长公共前缀
 */
class LeetCode {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","alight"};
        System.out.println(longestCommonPrefix(strs));
    }

    //思路
    //如果长度为0返回空字符串
    //将数组的第一个字符串作为条件，startsWith 依次比较后面字符串
    //不符合条件就将条件的字符长度递减
    public static String longestCommonPrefix(String[] strs) {

        String result = "";

        if (strs.length == 0) {
            return result;
        }

        result = strs[0];


        for (String str : strs) {
            while (!str.startsWith(result)) {
                result = result.substring(0, result.length() - 1);
            }
        }

        return result;
    }

}
