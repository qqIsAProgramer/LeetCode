package com.qyl.动态规划.买卖股票;

/**
 * @Author: qyl
 * @Date: 2021/3/14 19:49
 * @Description:
 */
public class MaxProfit3 {

    /**
     * 买卖股票第三题
     * id: 123
     * level: hard
     * 解法：
     * 过渡状态：
     * buy1 = Math.max(buy1, -prices[i]);
     * sell1 = Math.max(sell1, buy1 + prices[i]);
     * buy2 = Math.max(buy2, sell1 - prices[i]);
     * sell2 = Math.max(sell2, buy2 + prices[i]);
     * 初始状态：
     * buy1 = -prices[0];
     * sell1 = -∞;
     * buy2 = -∞;
     * sell2 = -∞;
     * 但如果 prices.length <= 1 时，最大利润是 0
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int buy1 = -prices[0];
        int sell1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return Math.max(sell1, sell2);
    }
}
