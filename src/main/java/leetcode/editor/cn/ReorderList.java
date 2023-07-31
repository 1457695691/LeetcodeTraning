package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 143. 重排链表
 * @date 2023/4/4 09:59
 */
public class ReorderList {
    /**
     * 0,n,1,n-1,2,n-2....
     * 找中点，断开，反转，连接
     */
    class Solution1 {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return;
            }
            //快慢指针找中点
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //断开
            ListNode second = slow.next;
            slow.next = null;
            //链表反转
            second = this.reserve(second);
            //节点依次连接
            ListNode cur = head;
            while (second != null) {
                ListNode next = cur.next;
                cur.next = second;
                second = second.next;
                cur.next.next = next;
                cur = next;
            }
        }

        private ListNode reserve(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }


    class Solution2 {
        public void reorderList(ListNode head) {
            Deque<ListNode> deque = new ArrayDeque<>();
            ListNode node = head;
            while (node != null) {
                deque.add(node);
                node = node.next;
            }
            List<ListNode> list = new ArrayList<>();
            boolean flag = true;
            while (!deque.isEmpty()) {
                if (flag) {
                    list.add(deque.pollFirst());
                } else {
                    list.add(deque.pollLast());
                }
                flag = !flag;
            }
            list.add(null);
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
        }
    }
}
