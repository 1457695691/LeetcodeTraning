package leetcode.editor.cn;

/**
 * 92. 反转链表 II
 *
 * @author Ayuan
 */
public class ReverseBetween {
    /**
     * 1.创建一个虚拟头结点
     * 2.遍历到left的前一个位置
     * 3.定义一个结点指向left的位置
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            for (int i = 1; i < left; i++) {
                pre = pre.next;
            }
            head = pre.next;
            for (int i = left; i < right; i++) {
                ListNode next = head.next;
                head.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            return dummy.next;
        }
    }
}
