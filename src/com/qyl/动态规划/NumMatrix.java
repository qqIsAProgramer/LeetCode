package com.qyl.动态规划;

/**
 * @Author: qyl
 * @Date: 2021/3/2 12:27
 * @Description:
 */
public class NumMatrix {

    /**
     * id: 304
     * level: middle
     * 解法：
     * 前缀和（二维数组每一行都变成前缀和）
     */

    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            prefix = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    prefix[i][j + 1] = prefix[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += prefix[i][col2 + 1] - prefix[i][col1];
        }
        return sum;
    }
}
