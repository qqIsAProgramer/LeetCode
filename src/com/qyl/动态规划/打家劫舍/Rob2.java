package com.qyl.动态规划.打家劫舍;

import java.util.Arrays;

/**
 * @Author: qyl
 * @Date: 2021/3/17 20:25
 * @Description:
 */
public class Rob2 {

    /**
     * 打家劫舍II（重点是收尾相连，偷了第一个就不能偷最后一个）
     * id: 213
     * level: middle
     * 解法：
     * 思路和 RobI 基本一样，最精彩的地方在于
     * 用 Math.max(maxProfit(Arrays.copyOfRange(nums, 0, n - 1)),
     *                 maxProfit(Arrays.copyOfRange(nums, 1, n)));
     * 来解决收尾相连问题
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        return Math.max(maxProfit(Arrays.copyOfRange(nums, 0, n - 1)),
                maxProfit(Arrays.copyOfRange(nums, 1, n)));
    }

    private int maxProfit(int[] nums) {
        int dp0 = 0;
        int dp1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int newDp0 = Math.max(dp0, dp1);
            int newDp1 = dp0 + nums[i];
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return Math.max(dp0, dp1);
    }
}
