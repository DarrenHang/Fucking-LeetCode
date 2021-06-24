package com.darren.leetcode.leetcode13;


/**
 * date  6/24/21  11:06 AM
 * author  DarrenHang
 * 罗马数字转整数
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    //思路
    //通过对比前后字符，如果前面的字符小于后面的字符，则减去字符，大于就加上
    //防止索引越界的问题，条件为 length - 1
    //最后需要加上索引为 length - 1 的值
    public static int romanToInt(String s) {

        int num = 0;
        int maxLength = s.length() - 1;

        for (int i = 0; i < maxLength; i++) {
            int current = getValue(s.charAt(i));
            int next = getValue(s.charAt(i + 1));
            if (current < next) {
                num -= current;
            } else {
                num += current;
            }
        }
        num += getValue(s.charAt(maxLength));
        return num;

    }

    //辅助函数，通过字符来获取对应的数值
    public static int getValue(char c) {
        int value = 0;
        switch (c) {
            case 'M':
                value = 1000;
                break;
            case 'D':
                value = 500;
                break;
            case 'C':
                value = 100;
                break;
            case 'L':
                value = 50;
                break;
            case 'X':
                value = 10;
                break;
            case 'V':
                value = 5;
                break;
            case 'I':
                value = 1;
                break;
        }
        return value;
    }

}
