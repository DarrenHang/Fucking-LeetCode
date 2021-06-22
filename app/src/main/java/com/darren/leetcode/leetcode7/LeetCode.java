package com.darren.leetcode.leetcode7;

/**
 * date  6/22/21  9:43 AM
 * author  DarrenHang
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(reverse(123456));
    }

    public static int reverse(int x) {
        //0 直接返回
        if (x == 0) return 0;
        long n = 0;
        //循环处理x
        while (x != 0) {
            //得到x的最后一位，依次累加
            n = n * 10 + x % 10;
            //去掉最后一位
            x = x / 10;
        }
        //如果大于最大或者小于最小则返回0，其他返回n
        return (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) ? 0 : (int) n;
    }

}

