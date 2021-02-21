package com.qyl.数学.滑动窗口;

import java.util.TreeMap;

/**
 * @Author: qyl
 * @Date: 2021/2/21 16:50
 * @Description:
 */
public class LongestSubarray_1438 {

    /**
     * level: middle
     * 给一个整数数组 nums ，和一个表示限制的整数 limit，返回最长连续子数组的长度
     * 该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit
     * 如果不存在满足条件的子数组，则返回 0
     * ----------------------------------------------------------------
     * 解法：
     * 核心思想是滑动窗口
     * 最重要是借助有序集合 TreeMap 来找到数组中最大以及最小的数，可以试着打草稿，非常容易理解
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        // TreeMap 是一个有序的 Map 集合，默认排序规则是从小到大
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int l = 0, r = 0;
        int maxlen = 0;
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }
}
