package com.darren.leetcode.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * date  6/24/21  2:06 PM
 * author  DarrenHang
 * 三数之和
 */
class LeetCode {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2, 0, 1, 1, 2}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //返回集合
        List<List<Integer>> result = new ArrayList<>();
        //数据为空返回空数组
        if (nums.length == 0) {
            return result;
        }
        //排序
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //如果第一个数大于0直接返回
            int target = nums[i];
            if (target > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //左指针
            int left = i + 1;
            //右指针
            int right = length - 1;
            while (left < right) {
                //左指针值
                int leftValue = nums[left];
                //右指针值
                int rightValue = nums[right];
                //标记位置数组和
                int value = target + leftValue + rightValue;
                if (value == 0) {
                    //将数据添加到数组
                    List<Integer> list = new ArrayList<>();
                    list.add(target);
                    list.add(leftValue);
                    list.add(rightValue);
                    result.add(list);
                    //处理重复问题，放在外面会有问题
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (value > 0) {
                    //如果数值大于0，说明最大数过大，所以右指针向左移动
                    right--;
                } else {
                    //如果数值小于0，说明最小数过小，所以左指针向右移动
                    left++;
                }
            }

        }
        return result;

    }

}
