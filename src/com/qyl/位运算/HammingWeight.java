package com.qyl.位运算;

/**
 * @Author: qyl
 * @Date: 2021/3/22 14:01
 * @Description:
 */
public class HammingWeight {

    /**
     * 汉明距离
     * id: 191
     * level: simple
     * 解法 1：
     * (n & (1 << i)) != 0 (可以手算演示)
     * @param n
     * @return
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 解法 2：
     * n & (n - 1) 的结果是 n 的最低位的 1 翻转为 0
     * 所以循环进行 n & (n - 1) 操作直到 n=0
     * 翻转了多少次，则 1 有多少位
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
