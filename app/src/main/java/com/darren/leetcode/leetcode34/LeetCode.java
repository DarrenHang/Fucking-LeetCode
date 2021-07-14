package com.darren.leetcode.leetcode34;

/**
 * date  7/9/21  5:38 PM
 * author  DarrenHang
 * 在排序数组中查找元素的第一个和最后一个位置
 */
class LeetCode {

    public static void main(String[] args) {
        int[] s = searchRange_(new int[]{5, 7, 7, 8, 8,8,8, 10}, 8);
    }

    //无优化，时间复杂度 O(n)
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int length = nums.length;
        if (length == 0) return result;
        int left = 0, right = 1, index = 0;
        while (index < length) {
            if (nums[index] == target) {
                if (result[left] == -1) {
                    result[left] = index;
                }
                result[right] = index;
            }
            index++;
        }
        return result;
    }

    //优化，时间复杂度O(logN)
    //思路：先通过二分法找到左结点
    //然后通过二分法查找右结点
    public static int[] searchRange_(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int length = nums.length;
        //数组长度为0 返回 -1
        if (length == 0) return result;
        //当不在区间内时返回 -1
        if (target < nums[0] || target > nums[length - 1]) return result;
        int left = 0, right = length - 1;
        //寻找左边界
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        //寻找右边界
        if (nums[left] != target) {
            return result;
        } else {
            result[0] = left;
            right = length - 1;
            while (left < right) {
                int mid = (left + right + 1) >> 1;
                if (nums[mid] <= target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            result[1] = left;
        }

        return result;
    }

}
