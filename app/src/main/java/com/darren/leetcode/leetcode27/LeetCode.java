package com.darren.leetcode.leetcode27;

/**
 * date  7/1/21  11:01 AM
 * author  DarrenHang
 * 移除元素
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (nums == null || length == 0) return 0;
        if (length == 1) return nums[0] == val ? 1 : 0;
        int current = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                current++;
                nums[current] = nums[i];
            }
        }
        return current;
    }

}
