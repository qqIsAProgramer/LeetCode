package com.qyl.位运算;

/**
 * @Author: qyl
 * @Date: 2021/3/22 14:09
 * @Description:
 */
public class GetSum {

    /**
     * 不使用 '+'/'-' 来相加两数
     * id: 371
     * level: middle
     * 解法：
     * a + b 的问题拆分为 (a 和 b 的无进位结果) + (a 和 b 的进位结果)
     * 无进位加法使用 异或运算 计算得出
     * 进位结果使用 与运算和移位运算 计算得出
     * 循环此过程，直到进位为 0
     * getSum(4, 5) -> getSum(1, 8) -> getSum(9, 0)
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
