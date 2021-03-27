package com.qyl.数学;

/**
 * @Author: qyl
 * @Date: 2021/3/27 17:36
 */
public class MyPow {

    /**
     * 自定义一个 Pow(x, n) 函数
     * id: 50
     * level: middle
     * 解法：
     * 快速幂（主要是分治的思想）
     * 例如：求 x ^ 64 和 y ^ 77
     * x ^ 64 = (x ^ 32) ^ 2 = ((x ^ 16) ^ 2) ^ 2 = ......
     * y ^ 77 = (y ^ 38) ^ 2 * y = ((y ^ 19) ^ 2) ^ 2 * y = ......
     * 看代码，很容易理解
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    private double quickMul(double x, int N) {
        if (N == 0) {
            return 1;  // x ^ 0 = 1
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
