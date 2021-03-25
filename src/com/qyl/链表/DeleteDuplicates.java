package com.qyl.链表;

/**
 * @Author: qyl
 * @Date: 2021/3/25 8:58
 * @Description:
 */
public class DeleteDuplicates {

    /**
     * id: 82
     * level: middle
     * 解法：
     * 主要在去重操作
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int x = curr.next.val;
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
