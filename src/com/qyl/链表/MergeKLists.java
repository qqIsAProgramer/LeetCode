package com.qyl.链表;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: qyl
 * @Date: 2021/3/21 9:46
 * @Description:
 */
public class MergeKLists {

    /**
     * 合并 k 个升序链表
     * id: 23
     * level: hard
     * 解法：
     * 使用优先队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        Queue<ListNode> queue = new PriorityQueue<>(((l1, l2) -> (l1.val - l2.val)));
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.offer(node.next);
            }
            head.next = node;
            head = head.next;
        }
        return dummy.next;
    }
}
