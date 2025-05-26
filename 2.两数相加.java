/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = createNode(l1.val + l2.val);

        l1 = l1.next;
        l2 = l2.next;
        ListNode temp = head;
        while (l1 != null || l2 != null) {
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (temp.next == null ? 0 : temp.next.val);
            
            temp.next = createNode(val);
            temp = temp.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head;
    }

    public ListNode createNode(int val) {
        if (val >= 10) {
            return new ListNode(val - 10, new ListNode(1));
        } else {
            return new ListNode(val);
        }
    }
}
// @lc code=end

