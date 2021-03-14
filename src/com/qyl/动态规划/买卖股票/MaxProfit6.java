package com.qyl.动态规划.买卖股票;

/**
 * @Author: qyl
 * @Date: 2021/3/13 19:57
 * @Description:
 */
public class MaxProfit6 {

    /**
     * 买卖股票含有手续费
     * id: 714
     * level: middle
     * 解法：
     * 与买卖股票第二题（id: 122）基本上相同，只是多了一个 fee
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }

    /**
     * 在 1 的基础上进行空间优化
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i] - fee);
            int newDp1 = Math.max(dp0 - prices[i], dp1);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
