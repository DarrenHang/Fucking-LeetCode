package com.darren.leetcode.leetcode35;

/**
 * date  7/14/21  11:34 AM
 * author  DarrenHang
 * 搜索插入位置
 */
class LeetCode {

    public static void main(String[] args) {
        searchInsert(new int[]{1, 3, 5, 6}, 7);
    }

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        //如果 target < 数组第一个数，返回 0
        if (nums[0] > target) return 0;
        //如果 target > 数组最后一个数，返回 length
        if (nums[length - 1] < target) return length;
        int index = 0;
        while (index < length) {
            if (nums[index] == target) {
                return index;
            } else if (nums[++index] > target) {
                break;
            }
        }
        return index;
    }

}
