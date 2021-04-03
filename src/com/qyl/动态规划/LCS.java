package com.qyl.动态规划;

/**
 * @Author: qyl
 * @Date: 2021/4/3 11:10
 */
public class LCS {

    /**
     * 最长公共子序列（超级经典的动态规划）
     * id: 1143
     * level: middle
     * 解法：
     * dp[i][j] 表示 text1[0:i] 与 text2[0:j] 的最长公共子序列长度
     * 当 text1[i - 1] = text2[j - 1] 时：
     * dp[i][j] = dp[i - 1][j - 1] + 1;
     * 当 text1[i - 1] != text2[j - 1] 时：
     * dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
     * 最后返回 dp[m][n]
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 最长公共子串
     * 解法：
     * dp[i][j] 表示 a[0:i] 与 b[0:j] 的最长公共子串长度
     * 当 a[i - 1] = b[j - 1] 时
     * dp[i][j] = dp[i - 1][j - 1] + 1;
     * 当 a[i - 1] != b[j - 1] 时
     * dp[i][j] = 0;
     * 要随时记录 dp[i][j] 的最大值 maxlen，并最终返回 maxlen
     * @param a
     * @param b
     * @return
     */
    public int longestCommonSubstring(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxlen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                maxlen = Math.max(maxlen, dp[i][j]);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
//        String a = "Commonmmn";
//        String b = "cmmn";
//        System.out.println(longestCommonSubstring(a, b));
    }
}
