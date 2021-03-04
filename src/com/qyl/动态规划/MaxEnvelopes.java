package com.qyl.动态规划;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: qyl
 * @Date: 2021/3/4 8:40
 * @Description:
 */
public class MaxEnvelopes {

    /**
     * id: 354
     * level: hard
     * 解法：
     * 与第 300 题类似
     * 固定住 envelopes[i][0]，让其比较 envelopes[i][1]
     * 但有个问题，如果 envelopes[i][0] 相等呢？那就需要把 envelopes[i][1] 降序排序，就可以解决
     * 剩下的就是 严格递增子序列 问题
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        // 本题精彩之处
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                return e1[0] != e2[0] ? e1[0] - e2[0] : e2[1] - e1[1];
            }
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxlen = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
    }
}
