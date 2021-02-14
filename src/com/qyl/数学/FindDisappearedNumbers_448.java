package com.qyl.数学;

import java.util.*;

/**
 * @Author: qyl
 * @Date: 2021/2/14 16:09
 * @Description: 找到所有数组中消失的数字
 */
public class FindDisappearedNumbers_448 {

    /**
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字
     * ------------------------------------------------------------------------------------------
     * 解法：
     * 让 nums 自身成为哈希表
     * 遍历 nums，每遇到一个数 xx，就让 nums[x−1] 增加 n
     * 由于 nums 中所有数均在 [1,n] 中，增加以后，这些数必然大于 n
     * 最后我们遍历 nums，若 nums[i] 未大于 n，就说明没有遇到过数 i+1
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int i = (num - 1) % n;
            nums[i] += n;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) res.add(i + 1);
        }
        return res;
    }
}
