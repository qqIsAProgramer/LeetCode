package com.qyl.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/3/28 20:21
 */
public class Subsets {

    /**
     * 子集（经典回溯）
     * id: 78
     * level: middle
     * 解法：
     * 回溯（模板）
     */

    private int n;
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(list));

        for (int i = start; i < n; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
