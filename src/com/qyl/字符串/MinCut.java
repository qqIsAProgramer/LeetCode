package com.qyl.字符串;

import java.util.Arrays;

/**
 * @Author: qyl
 * @Date: 2021/3/8 9:17
 * @Description:
 */
public class MinCut {

    /**
     * id: 132
     * level: hard
     * 解法：
     * 动态规划
     * 设 f[i] 表示字符串的前缀 s[0..i] 的最少分割次数
     * 要想得出 f[i] 的值，我们可以考虑枚举 s[0..i] 分割出的最后一个回文串，这样我们就可以写出状态转移方程：
     * f[i] = min(f[j]) + 1,  0 <= j < i
     * 即我们枚举最后一个回文串的起始位置 j+1，保证 s[j+1..i] 是一个回文串，那么 f[i] 就可以从 f[j] 转移而来，附加 1 次额外的分割次数
     * 注意到上面的状态转移方程中，我们还少考虑了一种情况，即 s[0..i] 本身就是一个回文串
     * 此时其不需要进行任何分割，即：f[i] = 0
     * @param s
     * @return
     */
    public int minCut(String s) {
        int n = s.length();
        /*
         * 细节
         * 判断 s[i..j] 是否为字符串时，常规方法是使用双指针指向 i 和 j，次判断两个指针指向的字符是否相同，直到两个指针相遇
         *
         * 然而这种方法会产生重复计算，例如下面这个例子：
         * 当 s = =aaba 时，对于前 2 个字符 aa，我们有 22 种分割方法 [aa] 和 [a,a]
         * 当我们每一次搜索到字符串的第 i=2 个字符 b 时，都需要对于每个 s[i..j] 使用双指针判断其是否为回文串，这就产生了重复计算
         *
         * 因此我们可以将字符串 s 的每个子串 s[i..j] 是否为回文串预处理出来，使用动态规划即可
         * 设 f(i,j) 表示 s[i..j] 是否为回文串，那么有状态转移方程：
         *          |- true,  i >= j
         * f(i,j) = |
         *          |- f(i+1,j-1) && (s[i] == s[j]),  otherwise
         * 即 s[i..j] 为回文串，当且仅当其为空串（i>j），其长度为 1（i=j），或者首尾字符相同且 s[i+1..j−1] 为回文串
         */
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                g[i][j] = g[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }
}
