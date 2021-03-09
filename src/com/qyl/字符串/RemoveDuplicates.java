package com.qyl.字符串;

/**
 * @Author: qyl
 * @Date: 2021/3/9 12:32
 * @Description:
 */
public class RemoveDuplicates {

    /**
     * id: 1047
     * level: simple
     * 解法：
     * 用 StringBuilder 即可（栈顶指针很巧妙）
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        // 栈顶指针
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (top >= 0 && ch == sb.charAt(top)) {
                sb.deleteCharAt(top);
                top--;
            } else {
                sb.append(ch);
                top++;
            }
        }
        return sb.toString();
    }
}
