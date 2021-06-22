package com.darren.leetcode.leetcode6;

/**
 * date  6/17/21  3:07 PM
 * author  DarrenHang
 * Z 字形变换
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }

    public static String convert(String s, int numRows) {
        //如果字符串为空或者字符串长度为1或者行数为1，直接返回字符串
        if (s == null || s.length() < 2 || numRows <= 1) return s;
        //创建对应的行数
        StringBuilder[] builders = new StringBuilder[numRows];
        //初始化 StringBuilder 数组
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        //方向：1向下，-1向上
        int dir = 1;
        //初始索引
        int index = 0;
        //便利字符串
        for (char c : s.toCharArray()) {
            //添加字符
            builders[index].append(c);
            index += dir;
            //当索引为 0 或者 numRows-1 时转变方向
            if (index == 0 || index == numRows - 1) {
                dir = -dir;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : builders) {
            result.append(sb);
        }
        return result.toString();
    }

}
