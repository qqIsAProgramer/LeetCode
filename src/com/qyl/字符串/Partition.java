package com.qyl.字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/3/7 9:36
 * @Description:
 */
public class Partition {

    /**
     * id: 131
     * level: middle
     * 解法：
     * 动态规划预处理（判断是否为回文串）+ 回溯
     */

    private boolean[][] f;
    private List<List<String>> res = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }

        // 预处理字符串
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = f[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int i) {
        // 0..n-1, 1..n-1, 2..n-1 ...
        if (i == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < n; j++) {
            if (f[i][j]) {
                list.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
