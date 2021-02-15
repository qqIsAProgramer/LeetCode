package com.qyl.数学;

/**
 * @Author: qyl
 * @Date: 2021/2/15 10:29
 * @Description:
 */
public class FindMaxConsecutiveOnes_485 {

    /**
     * 给定一个二进制数组， 计算其中最大连续1的个数
     * -------------------------------------
     * 简单题，开心一整天
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 0;
            }
        }
        return res;
    }
}
