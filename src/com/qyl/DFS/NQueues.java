package com.qyl.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/4/6 17:31
 */
public class NQueues {

    private int n;
    private List<List<String>> ans;
    private List<String> board;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        ans = new ArrayList<>();
        board = new ArrayList<>();

        StringBuilder sb = new StringBuilder().append(".".repeat(n));
        for (int i = 0; i < n; i++) {
            board.add(sb.toString());
        }

        dfs(0);
        return ans;
    }

    private void dfs(int row) {
        if (row == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(row, i)) continue;
            modify('Q', row, i);
            dfs(row + 1);
            modify('.', row, i);
        }
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void modify(char ch, int row, int col) {
        StringBuilder sb = new StringBuilder(board.get(row));
        sb.setCharAt(col, ch);
        board.set(row, sb.toString());
    }
}
