package leetcode.editor.cn;


/**
 * 25. K 个一组翻转链表
 *
 * @author Ayuan
 */
public class ReverseKGroup {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode a, b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                // 不足 k 个，不需要反转，base case
                if (b == null) {
                    return head;
                }
                b = b.next;
            }
            ListNode newHead = this.reverse(a, b);
            a.next = this.reverseKGroup(b, k);
            return newHead;
        }

        public ListNode reverse(ListNode a, ListNode b) {
            ListNode pre, cur, nxt;
            pre = null;
            cur = a;
            // while 终止的条件改一下就行了
            while (cur != b) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            // 返回反转后的头结点
            return pre;
        }
    }
}
