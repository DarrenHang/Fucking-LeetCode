package com.darren.leetcode.leetcode28;

/**
 * date  7/1/21  11:55 AM
 * author  DarrenHang
 * 实现 strStr()
 */
class LeetCode {

    public static void main(String[] args) {
        strStr("abc","c");
    }

    //解题思路
    public static int strStr(String haystack, String needle) {
        //当 needle 为空或者两个字符串相等时返回0
        if (needle.isEmpty() || haystack.equals(needle)) return 0;
        //当 haystack 为空时返回 -1
        if (haystack.isEmpty()) return -1;
        int hLength = haystack.length();
        int nLength = needle.length();
        //当 haystack 长度小于 needle 时返回 -1
        if (hLength < nLength) return -1;
        int pos = 0;
        //通过指针移动元素
        while (pos < hLength - nLength + 1) {
            String str = haystack.substring(pos, pos + nLength);
            //如果找到返回索引
            if (str.equals(needle)) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

}
