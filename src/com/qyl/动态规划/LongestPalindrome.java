package com.qyl.动态规划;

import java.util.Arrays;

/**
 * @Author: qyl
 * @Date: 2021/3/24 8:21
 * @Description:
 */
public class LongestPalindrome {

    /**
     * 找到最长回文子串
     * id: 5
     * level: middle
     * 解法：
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }

        int maxlen = Integer.MIN_VALUE;
        int start = 0, end = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    f[i][j] = f[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if (f[i][j]) {
                    if (maxlen < j - i + 1) {
                        maxlen = j - i + 1;
                        start = i;
                        end = j + 1;
                    }
                }
            }
        }
        return s.substring(start, end);
    }
}
