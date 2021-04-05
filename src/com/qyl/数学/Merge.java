package com.qyl.数学;

/**
 * @Author: qyl
 * @Date: 2021/4/5 11:04
 */
public class Merge {

    /**
     * 合并两个有序数组（原地）
     * id: 88
     * level: simple
     * 解法：
     * 从后往前合并
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n;
        while (n > 0) {
            while (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                int tmp = nums1[--m];
                nums1[m] = nums1[--i];
                nums1[i] = tmp;
            }
            int tmp = nums2[--n];
            nums2[n] = nums1[--i];
            nums1[i] = tmp;
        }
    }
}
