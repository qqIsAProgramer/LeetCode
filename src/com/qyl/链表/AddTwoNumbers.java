package com.qyl.链表;

/**
 * @Author: qyl
 * @Date: 2021/3/19 11:55
 * @Description:
 */
public class AddTwoNumbers {

    /**
     * 以链表的形式进行两数相加
     * id: 2
     * level: middle
     * 解法：
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);  // 虚节点
        ListNode head = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val = carry;
            if (l1 != null) val += l1.val;
            if (l2 != null) val += l2.val;
            carry = val / 10;
            val = val % 10;
            head.next = new ListNode(val);
            head = head.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
