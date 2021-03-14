package com.qyl.动态规划.买卖股票;

/**
 * @Author: qyl
 * @Date: 2021/3/13 17:04
 * @Description:
 */
public class MaxProfit5 {

    /**
     * 买卖股票含冷冻期
     * id: 309
     * level: middle
     * 解法：
     * 设 f[i]: 第 i 天结束后，累计获得的最大利益
     * f[i][0]: 持有一支股票
     * f[i][1]: 不持有股票，处于冷冻期
     * f[i][2]: 不持有股票，不处于冷冻期
     * 所以过渡状态为：
     * f[i][0] = max(f[i-1][0], f[i-1][2] - prices[i]) -> 第 i 天的股票来源可能是 i-1 已持有的或 i-1 天买入的
     * f[i][1] = f[i-1][0] + prices[i]
     * f[i][2] = max(f[i-1][2], f[i-1][1])
     * 设有 n 天，则：
     * ans = max(f[n-1][0], f[n-1][1], f[n-1][2])
     * 但 f[n-1][0] < f[n-1][1], f[n-1][2]
     * 初始：
     * f[0][0] = -prices[0]
     * f[0][1] = -infinity(不存在)
     * f[0][2] = 0
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        f[0][1] = Integer.MIN_VALUE;
        f[0][2] = 0;
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }


    /**
     * 在 1 的基础上进行空间优化，因为这些状态只与前一个状态有关
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int f0 = -prices[0];
        int f1 = Integer.MIN_VALUE;
        int f2 = 0;
        for (int i = 1; i < n; i++) {
            int newF0 = Math.max(f0, f2 - prices[i]);
            int newF1 = f0 + prices[i];
            int newF2 = Math.max(f1, f2);
            f0 = newF0;
            f1 = newF1;
            f2 = newF2;
        }
        return Math.max(f1, f2);
    }
}
