/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        
        ListNode l = head;
        ListNode r = l.next;
        for (int i = 0; i < n; i++) {
            if (r == null) {
                return l.next;
            }
            r = r.next;
        }

        while (r != null) {
            r = r.next;
            l = l.next;
        }

        l.next = l.next.next;

        return head;
    }
}
// @lc code=end

