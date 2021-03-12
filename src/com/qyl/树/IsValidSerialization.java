package com.qyl.树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: qyl
 * @Date: 2021/3/12 9:14
 * @Description:
 */
public class IsValidSerialization {

    /**
     * id: 331
     * level: middle
     * 解法：
     * 二叉树的建立也伴随着槽位数量的变化。每当遇到一个节点时：
     * 如果遇到了空节点，则要消耗一个槽位
     * 如果遇到了非空节点，则除了消耗一个槽位外，还要再补充两个槽位
     * 此外，还需要将根节点作为特殊情况处理
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // 根元素特殊处理
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                int top = stack.pop() - 1;
                if (top != 0) {
                    stack.push(top);
                }
                i++;
            } else {
                // 读一个数字
                // 可能不止是个位数
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top != 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 解法二：
     * 在一的基础上优化了空间，只用一个 slot 来代替槽位
     * @param preorder
     * @return
     */
    public boolean isValidSerialization2(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slot = 1;
        while (i < n) {
            if (slot == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                slot--;
                i++;
            } else {
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slot++;  // slot = slot + 2 - 1;
            }
        }
        return slot == 0;
    }
}
