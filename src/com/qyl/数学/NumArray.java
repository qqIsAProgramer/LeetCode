package com.qyl.数学;

/**
 * @Author: qyl
 * @Date: 2021/3/1 20:47
 * @Description:
 */
public class NumArray {

    /**
     * id: 303
     * level: simple
     * 解法：
     * 前缀和（用了一些很棒的处理手法）
     */

    int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }
}
