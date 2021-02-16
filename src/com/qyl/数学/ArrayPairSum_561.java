package com.qyl.数学;

import java.util.Arrays;

/**
 * @Author: qyl
 * @Date: 2021/2/16 20:57
 * @Description:
 */
public class ArrayPairSum_561 {

    /**
     * level: simple
     * 给定长度为 2n 的整数数组 nums
     * 将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn)，使得从 1 到 n 的 min(ai, bi) 总和最大
     * ------------------------------------------------------------------------------------------
     * 解法：
     * 先对数组进行排序，再把数组下标为偶数的加起来即为答案（可以很容易证明）
     * @param nums
     * @return 最大总和
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i += 2) {
            count += nums[i];
        }
        return count;
    }
}
