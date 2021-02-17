package com.qyl.数学;

/**
 * @Author: qyl
 * @Date: 2021/2/17 21:41
 * @Description:
 */
public class MatrixReshape_566 {

    /**
     * level: simple
     * 将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据
     * 给出一个由二维数组表示的矩阵，以及两个正整数 r 和 c，分别表示想要的重构的矩阵的行数和列数
     * ---------------------------------------------------------------------------
     * 解法：
     * 思路很简单
     * @param nums
     * @param r
     * @param c
     * @return 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] res = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            // 把二维数组换算成一维数组，可以很容易得出坐标
            res[i / c][i % c] = nums[i / n][i % n];
        }
        return res;
    }
}
