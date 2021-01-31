package com.qyl.图.并查集;

/**
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似
 * 如果这两个字符串本身是相等的，那它们也是相似的
 * 给你一个字符串列表 strs，列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词
 * 请问 strs 中有多少个相似字符串组？
 * -------------------------------------------------------------------------------
 * 思路及解法
 * 我们把每一个字符串看作点，字符串之间是否相似看作边，那么可以发现本题询问的是给定的图中有多少连通分量
 * 于是可以想到使用并查集维护节点间的连通性
 */
public class MinSimilarGroups_839 {

    private int[] f;

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] == i) {
                count++;
            }
        }
        return count;
    }

    private int find(int x) {
        if (x != f[x]) f[x] = find(f[x]);
        return f[x];
    }

    private void union(int x, int y) {
        f[find(x)] = find(y);
    }

    private boolean check(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) return false;
            }
        }
        return true;
    }
}
