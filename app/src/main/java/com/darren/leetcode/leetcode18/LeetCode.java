package com.darren.leetcode.leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * date  6/25/21  2:03 PM
 * author  DarrenHang
 *  四数之和
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-2, -1, 0, 0, 1, 2}, 0));
    }

    //四数之和与三数之和类似
    //解题思路
    //外层循环，固定一个数，得到与 target 的差值
    //内层循环，当作三数之和处理
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //结果
        List<List<Integer>> result = new ArrayList<>();
        //长度
        int length = nums.length;
        if (length < 4) {
            return result;
        }
        //排序
        Arrays.sort(nums);
        //如果最小的4个数相加大于target，说明不满足条件
        if (nums[0] + nums[1] + nums[2] + nums[3] > target) {
            return result;
        }
        //如果最大的4个数相加小于target，也不满足条件
        if (nums[length - 1] + nums[length - 2] + nums[length - 3] + nums[length - 4] < target) {
            return result;
        }

        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int value = target - nums[i];
            System.out.println(value);
            for (int j = i + 1; j < length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int all = nums[j] + nums[left] + nums[right];
                    if (all == value) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (right < left && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (all < value) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;

    }

}
