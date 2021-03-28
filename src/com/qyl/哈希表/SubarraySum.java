package com.qyl.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qyl
 * @Date: 2021/3/28 10:08
 */
public class SubarraySum {

    /**
     * 计算和为 k 的子数组一共有多少个
     * id: 560
     * level: middle
     * 解法：
     * 前缀和 + 哈希表
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // 这里是因为前缀和本身就是一个和为 k 的子数组，频数应该置为 1
        int preSum = 0;  // 前缀和
        int count = 0;
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
