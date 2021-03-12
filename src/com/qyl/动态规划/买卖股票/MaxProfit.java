package com.qyl.动态规划.买卖股票;

/**
 * @Author: qyl
 * @Date: 2021/3/12 20:52
 * @Description:
 */
public class MaxProfit {

    /**
     * 买卖股票第一题
     * id: 121
     * level: simple
     * 解法：
     * 动态规划（具体看代码，巧妙却简单易懂）
     * 如果后一个值比前一个值小，那么这个最大利益后一个肯定会比前一个大
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
