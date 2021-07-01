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

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty() || haystack.equals(needle)) return 0;
        if (haystack.isEmpty()) return -1;
        int hLength = haystack.length();
        int nLength = needle.length();
        if (hLength < nLength) return -1;
        int pos = 0;
        while (pos < hLength - nLength + 1) {
            String str = haystack.substring(pos, pos + nLength);
            if (str.equals(needle)) {
                return pos;
            }
            pos++;
        }
        return -1;
    }

}
