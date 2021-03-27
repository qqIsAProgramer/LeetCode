package com.qyl.链表;

/**
 * @Author: qyl
 * @Date: 2021/3/27 9:27
 */
public class RotateRight {

    /**
     * id: 61
     * level: middle
     * 解法：
     * 成环操作（不要怕算链表长度，不一定就是最差的办法）
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode iter = head;
        int len = 1;
        while (iter.next != null) {
            len++;
            iter = iter.next;
        }
        iter.next = head;  // 成环
        for (int i = 0; i < len - (k % len); i++) {
            iter = iter.next;
        }
        ListNode curr = iter.next;
        iter.next = null;
        return curr;
    }
}
