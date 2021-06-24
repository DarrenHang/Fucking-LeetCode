package com.darren.leetcode.leetcode16;

import java.util.Arrays;

/**
 * date  6/24/21  3:44 PM
 * author  DarrenHang
 * 最接近的三数之和
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    //与15题类似
    public static int threeSumClosest(int[] nums, int target) {
        //给数组排序
        Arrays.sort(nums);
        //初始值
        int result = nums[0] + nums[1] + nums[2];
        //数组长度
        int length = nums.length;
        for (int i = 0; i < length - 1 ; i++) {
            int currentValue = nums[i];
            //左指针
            int left = i + 1;
            //右指针
            int right = length - 1;
            while (left < right) {
                int leftValue = nums[left];
                int rightValue = nums[right];
                int value = currentValue + leftValue + rightValue;
                result = Math.abs(value - target) < Math.abs(result - target) ? value : result;
                if (value > target) {
                    right--;
                } else if (value < target) {
                    left++;
                } else {
                    return value;
                }
            }

        }

        return result;
    }

}
