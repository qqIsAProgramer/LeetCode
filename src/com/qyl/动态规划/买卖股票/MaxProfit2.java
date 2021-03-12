package com.qyl.动态规划.买卖股票;

/**
 * @Author: qyl
 * @Date: 2021/3/12 21:28
 * @Description:
 */
public class MaxProfit2 {

    /**
     * 买卖股票第二题
     * id: 122
     * level: simple
     * 解法：
     * 定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）
     * 状态转移方程：（非常巧妙）
     * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
     * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 在 1 的基础上优化空间，因为我们发现只和前一个状态有关
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
