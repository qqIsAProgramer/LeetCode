package com.qyl.哈希表;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: qyl
 * @Date: 2021/2/1 16:53
 */
public class FairCandySwap_888 {

    /**
     * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小
     * 所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量
     * ---------------------------------------------------------------------------------------------
     * 解法：
     * 设 x 为 A 的某个元素，y 为 B 的某个元素，设 delta = (sumA - sumB) / 2
     * 只需要满足 x = y + delta 即可
     * @param A
     * @param B
     * @return 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> set = new HashSet<>();
        for (int a : A) set.add(a);

        int[] ans = new int[2];
        for (int b : B) {
            int a = b + delta;
            if (set.contains(a)) {
                ans[0] = a;
                ans[1] = b;
                return ans;
            }
        }
        return null;
    }
}
