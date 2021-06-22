package com.darren.leetcode.leetcode8;

/**
 * date  6/22/21  10:48 AM
 * author  DarrenHang
 * 字符串转换整数
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(myAtoi("  12345678999 wwww 1234"));
    }

    //解题思路
    //1:去除空格
    //2:判断正负符号
    //3:判断数字是否越界
    public static int myAtoi(String s) {
        char[] str = s.toCharArray();
        //长度
        int strLength = str.length;
        //指针
        int pointer = 0;
        //1:去除空格
        while (pointer < strLength && str[pointer] == ' ') {
            pointer++;
        }
        if (pointer == strLength) {
            return 0;
        }
        //是否为负数
        boolean isNegative = false;
        //2:判断正负符号
        if (str[pointer] == '-') {
            isNegative = true;
            pointer++;
        } else if (str[pointer] == '+') {
            isNegative = false;
            pointer++;
        } else if (!Character.isDigit(str[pointer])) {
            return 0;
        }
        //初始化最终结果
        int result = 0;
        while (pointer < strLength && Character.isDigit(str[pointer])) {
            int number = str[pointer] - '0';

            //3:判断是否越界
            if (result > (Integer.MAX_VALUE - number) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + number % 10;
            pointer++;
        }
        return isNegative ? -result : result;
    }

}
