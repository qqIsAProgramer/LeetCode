package com.qyl.动态规划;

/**
 * @Author: qyl
 * @Date: 2021/4/2 10:52
 */
public class Trap {

    /**
     * 接雨水
     * id: 42
     * level: hard
     * 解法：
     * 参见官方题解的图，非常容易理解
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        if (n < 1) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 取交集
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
