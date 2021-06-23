package com.darren.leetcode.leetcode11;

/**
 * date  6/23/21  9:36 AM
 * author  DarrenHang
 * 盛最多水的容器
 */
class LeetCode {

    public static void main(String[] args) {

    }

    //暴力破解必超时
    public int maxArea(int[] height) {
        //长度
        int length = height.length;

        if (length < 2) {
            return 0;
        }

        //最大面积
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                result = Math.max(Math.min(height[i], height[j]) * (j - i), result);
            }
        }
        return result;
    }

    //双指针
    public int maxArea_(int[] height) {
        //长度
        int length = height.length;
        //长度小于2返回0
        if (length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int result = 0;

        while (left < right) {
            result = Math.max((right - left) * Math.min(height[left], height[right]), result);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

}
