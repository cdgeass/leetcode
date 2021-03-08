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
        ListNode result = head;

        ListNode deleted = head;
        ListNode preDeleted = null;
        int deletedCur = 0;

        while (head.next != null) {
            head = head.next;
            deletedCur++;

            if (deletedCur >= n) {
                preDeleted = deleted;
                deleted = deleted.next;
            }
        }

        if (preDeleted == null) {
            return result.next;
        } else {
            preDeleted.next = deleted.next;
        }

        return result;
    }

}
// @lc code=end

