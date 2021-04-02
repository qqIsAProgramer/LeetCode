package com.qyl.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: qyl
 * @Date: 2021/3/26 22:31
 */
public class NumIslands {

    /**
     * 岛屿数量
     * id: 200
     * level: middle
     * 解法：
     * BFS
     * 细节：
     * int[] x = new int[]{0, 0, 1, -1};
     * int[] y = new int[]{1, -1, 0, 0};
     * 使用这两个数组进行上下移动
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int[] x = new int[]{0, 0, 1, -1};
        int[] y = new int[]{1, -1, 0, 0};

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] pair = queue.poll();
                        int x1 = pair[0];
                        int y1 = pair[1];
                        for (int k = 0; k < 4; k++) {
                            int x2 = x1 + x[k];
                            int y2 = y1 + y[k];
                            if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n) {
                                if (grid[x2][y2] == '1') {
                                    grid[x2][y2] = '0';
                                    queue.offer(new int[]{x2, y2});
                                }
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
