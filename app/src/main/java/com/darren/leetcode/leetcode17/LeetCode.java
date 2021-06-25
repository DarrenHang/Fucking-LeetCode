package com.darren.leetcode.leetcode17;

import java.util.ArrayList;
import java.util.List;

/**
 * date  6/25/21  8:51 AM
 * author  DarrenHang
 * 电话号码的字母组合
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        //返回结果
        List<String> result = new ArrayList<>();
        //长度
        int length = digits.length();
        //不满足条件返回空列表
        if (length == 0 || length > 4) {
            return result;
        }
        String[] phones = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < length; i++) {
            result = combine(result, phones[digits.charAt(i) - '0']);
        }

        return result;
    }

    //合并
    public static List<String> combine(List<String> result, String str) {
        List<String> list = new ArrayList<>();
        String emptyStr = "";
        for (int i = 0; i < str.length(); i++) {
            //如果数组为空，则直接添加字符
            if (result.isEmpty()) {
                list.add(str.charAt(i) + emptyStr);
            } else {
                for (String s : result) {
                    list.add(s + str.charAt(i));
                }
            }
        }
        return list;
    }

}
