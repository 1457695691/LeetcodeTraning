package leetcode.editor.cn;

/**
 * 剑指 Offer 24. 反转链表
 * 206. 反转链表
 *
 * @author Ayuan
 */
public class ReverseList {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null, cur = head, next;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
