package com.qyl.数学;

/**
 * @Author: qyl
 * @Date: 2021/3/20 9:40
 * @Description:
 */
public class MaxArea {

    /**
     * 盛水最多的容器
     * id: 11
     * level: middle
     * 解法：
     * 双指针，一个在左，一个在右
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
