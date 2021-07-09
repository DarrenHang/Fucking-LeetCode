package com.darren.leetcode.leetcode33;

/**
 * date  7/9/21  3:43 PM
 * author  DarrenHang
 * 搜索旋转排序数组
 */
class LeetCode {

    public static void main(String[] args) {
        search_(new int[]{4,5,6,7,0,1,2},0);
    }

    //无优化，时间复杂度 O(n)
    public static int search(int[] nums, int target) {
        int length = nums.length;
        int index = 0;
        boolean hasNumber = false;
        while (index < length) {
            if (nums[index] == target) {
                hasNumber = true;
                break;
            } else {
                index++;
            }
        }
        return hasNumber ? index : -1;
    }

    //优化
    public static int search_(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target<= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}
