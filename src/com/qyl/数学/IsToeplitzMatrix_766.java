package com.qyl.数学;

/**
 * @Author: qyl
 * @Date: 2021/2/22 15:49
 * @Description:
 */
public class IsToeplitzMatrix_766 {

    /**
     * level: simple
     * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是托普利茨矩阵
     * 给一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false
     * ----------------------------------------------------------------------------
     * 解法：
     * 从 matrix[1][1] 开始遍历，只需要与其左上角的元素进行比较，如果有不相等即返回 false；反之返回 true
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
