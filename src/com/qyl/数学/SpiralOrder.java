package com.qyl.数学;

import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/3/15 9:27
 * @Description:
 */
public class SpiralOrder {

    /**
     * 螺旋矩阵II
     * id: 59
     * level: middle
     * 解法：
     * 模拟法，设定边界（非常秀）
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;  // 边界
        int num = 1;  // 初始值
        int tar = n * n;  // 目标值
        while (num <= tar) {
            for (int i = l; i <= r; i++) mat[t][i] = num++;  // left to right
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++;  // top to bottom
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++;  // right to left
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++;  // bottom to top
            l++;
        }
        return mat;
    }
}
