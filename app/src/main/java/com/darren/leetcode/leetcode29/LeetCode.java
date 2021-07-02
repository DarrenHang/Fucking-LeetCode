package com.darren.leetcode.leetcode29;

/**
 * date  7/1/21  3:32 PM
 * author  DarrenHang
 * 两数相除
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648
                , -2147483648));
    }

    //解题思路，使用位运算
    public static int divide(int dividend, int divisor) {
        //除数为0或者两者为负时 dividend > divisor 或者两者为正时 dividend < divisor
        if ((divisor == 0) || (dividend < 0 && divisor < 0 && dividend > divisor) || (dividend > 0 && divisor > 0 && dividend < divisor))
            return 0;
        //超出范围返回
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        //divisor 为 -1 返回 -dividend
        if (divisor == -1) return -dividend;
        //divisor 为 1 返回 dividend
        if (divisor == 1) return dividend;
        //判断正负
        boolean negative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        //取反
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        //结果
        int result = 0;

        while (dividend <= divisor) {
            //临时变量
            long tmp = divisor;
            //次数
            long times = 1;
            //找到最接近 dividend 的数
            while (tmp << 1 > dividend) {
                tmp = tmp << 1;
                times = times << 1;
            }
            //累加次数
            result += times;
            //减去范围内的最大值，进行下次循环
            dividend -= tmp;
        }

        return negative ? -result : result;
    }

}
