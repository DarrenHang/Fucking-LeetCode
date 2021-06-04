package com.darren.leetcode.leetcode1;

import java.util.HashMap;

/**
 * date  4/1/21  4:18 PM
 * author  DarrenHang
 * 两数之和
 */
class LeetCode {

    static int numbers[] = new int[]{2, 5, 5, 15};
    static int target = 10;

    public static void main(String[] args) {
        int[] results = twoSum_(numbers, target);
        for (int result : results) {
            System.out.println(result);
        }
    }

    //暴力破解法
    //时间复杂度 O(n^2)
    //空间负责度 O(1)
    //解题思路：通过两次循环将所有的数都相加一次，最终找到符合条件的一组下表
    public static int[] twoSum(int[] numbers, int target) {
        //数组长度
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //哈希
    //时间复杂度 O(n)
    //空间复杂度 O(n)
    //解题思路：通过 hash 表的唯一性找到符合的两个数
    public static int[] twoSum_(int[] numbers, int target) {
        //数组长度
        int size = numbers.length;
        //创建集合
        HashMap<Integer, Integer> hashMap = new HashMap();
        //将第一个元素存入集合,将值作为键，将索引作为值
        hashMap.put(numbers[0], 0);
        for (int i = 1; i < size; i++) {
            //如果 target - 当前值在集合中存在就直接返回
            int has = target - numbers[i];
            if (hashMap.containsKey(has)) {
                return new int[]{hashMap.get(has), i};
            }
            //如果不存在就添加
            hashMap.put(numbers[i], i);
        }
        return null;
    }
}
