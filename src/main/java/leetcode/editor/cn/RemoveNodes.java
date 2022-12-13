package leetcode.editor.cn;

import javafx.util.Pair;

/**
 * @author Ayuan
 * @Description: 2487. 从链表中移除节点
 * @date 2022/12/13 10:46
 */
public class RemoveNodes {


    class Solution {
        public ListNode removeNodes(ListNode head) {
            if (head.next == null) {
                return head;
            }
            head.next = removeNodes(head.next);
            if (head.val < head.next.val) {
                return head.next;
            }
            return head;
        }
    }
}
