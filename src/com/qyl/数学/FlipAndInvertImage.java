package com.qyl.数学;

/**
 * @Author: qyl
 * @Date: 2021/2/24 0:06
 * @Description:
 */
public class FlipAndInvertImage {

    /**
     * id: 832
     * level: simple
     * 解法：
     * 主要考虑的是如何把空间复杂度降为 O(1)
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                if (A[i][l] == A[i][r]) {
                    A[i][l] ^= 1;
                    A[i][r] ^= 1;
                }
                l++;
                r--;
            }
            if (l == r) {
                A[i][l] ^= 1;
            }
        }
        return A;
    }
}
