package com.qyl.链表;

/**
 * @Author: qyl
 * @Date: 2021/3/18 8:40
 * @Description:
 */
public class ReverseBetween {

    /**
     * 反转 [m, n] 之间的链表
     * id: 92
     * level: middle
     * 解法：
     * 最核心的部分是
     * 1 - 2 - 3 - 4 - 5
     * 1 - 3 - 2 - 4 - 5
     * 1 - 4 - 3 - 2 - 5
     * 实现的代码是
     * next = curr.next;
     * curr.next = next.next;
     * next.next = curr;
     * pre.next = next;
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode curr = pre.next;
        ListNode next;
        for (int i = left; i < right; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = curr;
            pre.next = next;
        }
        return dummy.next;
    }
}
