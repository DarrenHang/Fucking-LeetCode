package com.darren.leetcode.leetcode31;

import java.util.Arrays;

/**
 * date  7/7/21  4:58 PM
 * author  DarrenHang
 */
class LeetCode {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 5, 5, 4, 3, 7, 4, 4};
        nextPermutation(nums);
    }


    public static void nextPermutation(int[] nums) {
        //长度
        int length = nums.length;
        if (length == 1) return;
        //目标索引
        int target = -1;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                target = i;
                break;
            }
        }
        System.out.println("目标索引：" + target);
        //如果没有找，直接反转数组
        if (target == -1) {
            Arrays.sort(nums);
            return;
        }
        int next = target;
        //在 target 的右侧寻找到离 target 最接近的值并记录索引
        for (int i = target + 1; i < length; i++) {
            if (nums[i] > nums[target]) {
                next = i;
            }
        }
        System.out.println("交换位置：" + next);
        int cur = nums[target];
        nums[target] = nums[next];
        nums[next] = cur;
        //对 target 之后的位置开始排序
        for (int i = target + 1; i < length; i++) {
            int pos = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[i]) {
                    pos = j;
                }
            }
            if (nums[i] > nums[pos]) {
                int tmp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = tmp;
            }
        }
    }

}
