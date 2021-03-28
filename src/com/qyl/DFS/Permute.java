package com.qyl.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/3/28 20:12
 */
public class Permute {

    /**
     * 全排列（经典回溯问题）
     * id: 46
     * level: middle
     * 解法：
     * 回溯（模板代码）
     */

    private int n;
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            dfs(nums);
            list.remove(list.size() - 1);
        }
    }
}
