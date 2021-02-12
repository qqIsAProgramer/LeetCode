package com.qyl.动态规划;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/2/12 17:47
 * @Description:
 */
public class GetRow_119 {

    /**
     * 杨辉三角
     * 给定一个非负索引 k，返回杨辉三角的第 k 行
     * @param rowIndex
     * @return 杨辉三角的第 k 行
     */
    public List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i < dp.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return Arrays.asList(dp);
    }
}
