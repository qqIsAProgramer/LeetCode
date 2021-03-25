package com.qyl.动态规划;

/**
 * @Author: qyl
 * @Date: 2021/3/25 8:31
 * @Description:
 */
public class MaxProduct {

    /**
     * 最大乘积的子数组
     * id: 152
     * level: middle
     * 解法：
     * 设 f[i][1] 表示前 i 个元素中的子数组的最大乘积，f[i][0] 表示前 i 个元素中的子数组的最小乘积（因为有负数）
     * 所以过渡方程为：
     * f[i][0] = Math.min(f[i - 1][1] * nums[i], Math.min(f[i - 1][0] * nums[i], nums[i]));
     * f[i][1] = Math.max(f[i - 1][0] * nums[i], Math.max(f[i - 1][1] * nums[i], nums[i]));
     * 只要随时记录 f[i][1] 即可
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }

        int[][] f = new int[n][2];
        f[0][0] = nums[0];
        f[0][1] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.min(f[i - 1][1] * nums[i], Math.min(f[i - 1][0] * nums[i], nums[i]));
            f[i][1] = Math.max(f[i - 1][0] * nums[i], Math.max(f[i - 1][1] * nums[i], nums[i]));
            res = Math.max(res, f[i][1]);
        }
        return res;
    }

    /**
     * 在 1 的基础上空间优化
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }

        int maxPro = nums[0], minPro = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            int tmp1 = Math.min(maxPro * nums[i], Math.min(minPro * nums[i], nums[i]));
            int tmp2 = Math.max(minPro * nums[i], Math.max(maxPro * nums[i], nums[i]));
            minPro = tmp1;
            maxPro = tmp2;
            res = Math.max(res, maxPro);
        }
        return res;
    }
}
