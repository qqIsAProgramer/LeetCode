package com.qyl.动态规划.打家劫舍;

/**
 * @Author: qyl
 * @Date: 2021/3/17 19:49
 * @Description:
 */
public class Rob {

    /**
     * 打家劫舍I
     * id: 198
     * level: simple
     * 解法：
     * 设 dp[i][0] 为不偷第 i 个房屋的累计最大金额，dp[i][1] 为偷第 i 个房屋的累计最大金额
     * 所以状态转移方程为：
     * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
     * dp[i][1] = dp[i - 1][0] + nums[i];
     * 最后返回 max(dp[n - 1][0], dp[n - 1][1])
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 在 1 的基础上进行空间优化（只与上一个状态有关）
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dp0 = 0;
        int dp1 = nums[0];
        for (int i = 1; i < n; i++) {
            int newDp0 = Math.max(dp0, dp1);
            int newDp1 = dp0 + nums[i];
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return Math.max(dp0, dp1);
    }
}
