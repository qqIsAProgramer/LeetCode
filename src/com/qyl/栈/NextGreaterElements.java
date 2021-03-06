package com.qyl.栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: qyl
 * @Date: 2021/3/6 9:47
 * @Description:
 */
public class NextGreaterElements {

    /**
     * id: 503
     * level: middle
     * 解法：
     * 巧妙地使用栈
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        // 1 2 1 4 3
        // 2 4 4 -1 4

        // 3 4 1 3 2
        // 4 -1 3 4 3
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}
