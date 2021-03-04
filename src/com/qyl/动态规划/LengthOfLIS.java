package com.qyl.动态规划;

/**
 * @Author: qyl
 * @Date: 2021/3/4 11:10
 * @Description:
 */
public class LengthOfLIS {

    /**
     * id: 300
     * level: middle
     * 最长递增子序列问题（重要）
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxlen = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxlen = Math.max(dp[i], maxlen);
        }
        return maxlen;
    }
}
