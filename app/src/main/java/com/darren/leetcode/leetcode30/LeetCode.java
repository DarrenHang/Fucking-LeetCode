package com.darren.leetcode.leetcode30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * date  7/6/21  9:10 AM
 * author  DarrenHang
 * 串联所有单词的子串
 */
class LeetCode {


    public static void main(String[] args) {
        System.out.println(findSubstring("foo", new String[]{"foo", "foo", "foo"}));
    }

    //解题思路
    //如果 words 为空直接返回空数组
    //如果 words 为 1。并且与字符串相等，直接返回0
    //用一个 HashMap 用来存放单词出现的次数 allWords
    //便利字符串 长度为 s.length - 数组长度 x 数组字符长度 + 1 ,为了防止越界
    //用另外一个 HashMap 用来记录单词出现的次数 hasWords，如果当前存放的次数大于 allWords 中存放的次数，进行下一次循环
    public static List<Integer> findSubstring(String s, String[] words) {
        //结果
        List<Integer> result = new ArrayList<>();
        //单词数组长度
        int wordSize = words.length;
        //数组为空返回空
        if (wordSize == 0) return result;
        //当数组长度为1并且与字符串相等，返回0
        if (wordSize == 1 && words[0].equals(s)) {
            result.add(0);
            return result;
        }
        //存放单词
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String str : words) {
            int value = allWords.getOrDefault(str, 0);
            allWords.put(str, value + 1);
        }
        //字符串长度
        int length = s.length();
        //单词长度
        int wordLength = words[0].length();
        for (int i = 0; i < length - wordSize * wordLength + 1; i++) {
            HashMap<String, Integer> hasWords = new HashMap<>();
            int num = 0;
            while (num < wordSize) {
                String word = s.substring(i + num * wordLength, i + (num + 1) * wordLength);
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            if (num == wordSize) {
                result.add(i);
            }
        }
        return result;
    }

}
