package com.darren.leetcode.leetcode26;

/**
 * date  7/1/21  10:44 AM
 * author  DarrenHang
 * 删除有序数组中的重复项
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int length = nums.length;
        int current = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != nums[current]) {
                current++;
                nums[current] = nums[i];
            }
        }
        return current + 1;
    }

}
