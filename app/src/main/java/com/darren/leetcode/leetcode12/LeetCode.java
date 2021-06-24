package com.darren.leetcode.leetcode12;

import java.util.HashMap;

/**
 * date  6/23/21  5:32 PM
 * author  DarrenHang
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(intToRoman_(40));
    }


    //暴力破解
    public static String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        while (num >= 1000) {
            sb.append("M");
            num -= 1000;
        }

        if (num >= 500) {
            if (num >= 900) {
                sb.append("CM");
                num -= 900;
            } else {
                sb.append("D");
                num -= 500;

                while (num >= 100) {
                    sb.append("C");
                    num -= 100;
                }

            }
        } else {
            if (num >= 400) {
                sb.append("CD");
                num -= 400;
            } else {

                while (num >= 100) {
                    sb.append("C");
                    num -= 100;
                }
            }
        }

        if (num >= 90) {
            sb.append("XC");
            num -= 90;
        } else {

            if (num >= 50) {
                sb.append("L");
                num -= 50;
            } else {
                if (num >= 40) {
                    sb.append("XL");
                    num -= 40;
                }
            }

            while (num >= 10) {
                sb.append("X");
                num -= 10;
            }
        }

        if (num >= 9) {
            sb.append("IX");
            num -= 9;
        } else {

            if (num >= 5) {
                sb.append("V");
                num -= 5;
            } else {
                if (num >= 4) {
                    sb.append("IV");
                    num -= 4;
                }
            }

            while (num >= 1) {
                sb.append("I");
                num -= 1;
            }
        }


        return sb.toString();
    }


    //递归
    public static String intToRoman_(int num) {
        if (num >= 1000) return "M" + intToRoman_(num -= 1000);
        if (num >= 900) return "CM" + intToRoman_(num -= 900);
        if (num >= 500) return "D" + intToRoman_(num -= 500);
        if (num >= 400) return "CD" + intToRoman_(num -= 400);
        if (num >= 100) return "C" + intToRoman_(num -= 100);
        if (num >= 90) return "XC" + intToRoman_(num -= 90);
        if (num >= 50) return "L" + intToRoman_(num -= 50);
        if (num >= 40) return "XL" + intToRoman_(num -= 40);
        if (num >= 10) return "X" + intToRoman_(num -= 10);
        if (num >= 9) return "IX" + intToRoman_(num -= 9);
        if (num >= 5) return "V" + intToRoman_(num -= 5);
        if (num >= 4) return "IV" + intToRoman_(num -= 4);
        if (num >= 1) return "I" + intToRoman_(num -= 1);
        else return "";
    }

    //贪心算法
    public static String intToRoman__(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romas = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (num >= nums[i]) {
                    num -= nums[i];
                    sb.append(romas[i]);
                    break;
                }
            }
        }
        return sb.toString();
    }


}
