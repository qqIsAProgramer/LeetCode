package com.qyl.数学.滑动窗口;

/**
 * @Author: qyl
 * @Date: 2021/2/23 23:31
 * @Description:
 */
public class MaxSatisfied_1052 {

    /**
     * level: middle
     * 题目详情见题号：1052
     * -----------------
     * 解法：
     * 滑动窗口
     * 先不考虑 X 分钟，把 grumpy[i] = 0 时的 customers[i] 加起来得到 pre
     * 现在考虑 X 分钟，其实 X 分钟就是一个长度为 X 的子数组
     * 只要把长度为 X 的子数组中 grumpy[i] = 1 加起来，通过滑动窗口来得出最大增加值 maxIncr
     * 最后将 maxIncr + pre 即为最终结果
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                pre += customers[i];
            }
        }
        int incr = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                incr += customers[i];
            }
        }
        int maxIncr = incr;
        for (int i = X; i < n; i++) {
            incr += customers[i] * grumpy[i] - customers[i - X] * grumpy[i - X];
            maxIncr = Math.max(maxIncr, incr);
        }
        return pre + maxIncr;
    }
}
