package com.qyl.动态规划;

/**
 * @Author: qyl
 * @Date: 2021/3/23 10:28
 * @Description:
 */
public class IsMatch {

    /**
     * 正则表达式匹配
     * id: 10
     * level: hard
     * 解法：
     * 说的是啥咱也没看懂
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(p.charAt(j - 1) == '*') {  // p的第j个字符为*
                    if(match(s, p, i, j - 1)) {  // 匹配s的第i个字符和p的第j-1个字符
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];  // p中*前面的字符在s中出现多次或者在s中只出现1次
                    }
                    else {
                        dp[i][j] = dp[i][j - 2];  // p中*前面的在s中字符出现0次
                    }
                } else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
