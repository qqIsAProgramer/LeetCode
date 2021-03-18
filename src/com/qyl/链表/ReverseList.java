package com.qyl.链表;

/**
 * @Author: qyl
 * @Date: 2021/3/18 8:47
 * @Description:
 */
public class ReverseList {

    /**
     * 反转链表
     * id: 206
     * level: simple
     * 解法：
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode pre = null;
        ListNode tmp;
        while (curr != null) {
            tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }
}
