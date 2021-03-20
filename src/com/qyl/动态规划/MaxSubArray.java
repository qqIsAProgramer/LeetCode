package com.qyl.动态规划;

/**
 * @Author: qyl
 * @Date: 2021/3/20 9:28
 * @Description:
 */
public class MaxSubArray {

    /**
     * 最大子数组之和
     * id: 53
     * level: simple
     * 解法：
     * 设 f(i) 为以第 i 个数结尾的「连续子数组的最大和」，那么很显然我们要求的答案就是：
     * f(i) = max(f(i-1)+nums[i], nums[i])
     * 对其进行空间优化，即：
     * dp = Math.max(dp + num, num);
     * ans = Math.max(dp, ans);
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int dp = 0;
        for (int num : nums) {
            dp = Math.max(dp + num, num);
            ans = Math.max(dp, ans);
        }
        return ans;
    }
}
