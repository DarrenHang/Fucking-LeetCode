package com.darren.leetcode.leetcode4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * date  4/1/21  4:18 PM
 * author  DarrenHang
 */
class LeetCode {

    public static void main(String[] args) {
        double result = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(result);
    }

    //暴力破解
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //数组 1 长度
        int m = nums1.length;
        //数组 2 长度
        int n = nums2.length;
        //当数组 1 长度为空，数组 2 长度为奇数时返回索引为 n/2，为偶数时返回 (n/2 + n/2-1)/2
        if (m == 0) return (n % 2 == 0) ? (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0 : nums2[n / 2];
        //当数组 2 长度为空，数组 1 长度为奇数时返回索引为 m/2，为偶数时返回 (m/2 + m/2-1)/2
        if (n == 0) return (m % 2 == 0) ? (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0 : nums1[m / 2];
        int mn = m + n;
        List<Integer> results = new ArrayList(m + n);
        for (int i = 0; i < m; i++) results.add(nums1[i]);
        for (int i = 0; i < n; i++) results.add(nums2[i]);
        Collections.sort(results);
        return mn % 2 == 0 ? (results.get(mn / 2) + results.get(mn / 2 - 1)) / 2.0 : results.get(mn / 2);
    }
}
