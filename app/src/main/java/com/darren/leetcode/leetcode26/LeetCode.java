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

    //解题思路
    //从第一个元素开始便利
    //区分 ++current 和 current++
    // current = 1 int a = ++current a = 2 current = 2
    // current = 1 int b = current++ b = 1 current = 2
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int length = nums.length;
        int current = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[current]) {
                nums[++current] = nums[i];
            }
        }
        return current + 1;
    }

}
