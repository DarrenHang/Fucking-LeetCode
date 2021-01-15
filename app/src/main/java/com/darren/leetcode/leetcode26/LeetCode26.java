package com.darren.leetcode.leetcode26;

/**
 * date  1/15/21  11:02 AM
 * author  DarrenHang
 */
class LeetCode26 {

    /**
     * leetcode26:删除排序数组中的重复项
     */
    public static void main(String[] args) {
        int num[] = new int[]{1, 1, 2, 3};
        int result = removeDuplicates(num);
        System.out.println("num.size:" + result);
    }

    //双指针判断，current = 0 和 next = 1
    //如果 current 等于 next，就让 next + 1
    //如果 current 不等于 next，就让 current + 1 等于 next ，然后让 next +1，接着往后循环
    public static int removeDuplicates(int[] num) {
        if (num == null || num.length == 0) return 0;
        if (num.length == 1) return 1;
        int current = 0;
        int next = 1;
        while (next < num.length) {
            if (num[current] != num[next]) {
                num[++current] = num[next];
            }
            next++;
        }
        return current + 1;
    }

    //第二种和第一种思路差不多
    public static int removeDuplicates_(int[] num) {
        if (num == null || num.length == 0) return 0;
        if (num.length == 1) return 1;
        int current = 0;
        for (int i = 1; i < num.length; i++) {
            if (num[i] != num[current]) {
                num[++current] = num[i];
            }
        }
        return current + 1;
    }


}
