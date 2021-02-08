package com.qyl.字符串.滑动窗口;

/**
 * @Author: qyl
 * @Date: 2021/2/2 16:36
 */
public class CharacterReplacement_424 {

    /**
     * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次
     * 在执行上述操作后，找到包含重复字母的最长子串的长度
     * -----------------------------------------------------------------------------------
     * 解法：
     * 滑动窗口（非常多细节）
     * @param s 由大写英文字母组成的字符串
     * @param k 替换次数
     * @return
     */
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;

        int res = 0;
        int maxCount = 0;
        int[] freq = new int[26];
        while (right < len) {
            freq[charArray[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[charArray[right] - 'A']);
            right++;
            if (right - left > maxCount + k) {
                freq[charArray[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
