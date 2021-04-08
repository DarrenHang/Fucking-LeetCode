package com.darren.leetcode.leetcode3;


import java.util.HashMap;

/**
 * date  4/1/21  4:18 PM
 * author  DarrenHang
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        //字符串长度
        int length = s.length();
        //如果是空字符串返回 0
        if (length == 0) return 0;
        //返回最长子串长度，初始化为 0
        int childSize = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int current = 0; current < length; current++) {
            //当前位置的字符串
            char c = s.charAt(current);
            //如果 map 中包含当前字母，移动左边的指针
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            //添加当前字符串
            map.put(c, current);
            //记录当前不重复字符串的长度
            childSize = Math.max(childSize, current - left + 1);
        }
        return childSize;
    }

}
