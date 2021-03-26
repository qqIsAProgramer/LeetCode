package com.qyl.链表;

/**
 * @Author: qyl
 * @Date: 2021/3/26 8:39
 * @Description:
 */
public class RemoveNthFromEnd {

    /**
     * 删除链表倒数第 n 个节点
     * id: 19
     * level: middle
     * 解法：
     * 主要思想是使用快慢指针找到倒数第 n 个节点
     * 就是在一些边界条件需要仔细处理（使用虚头节点）
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
