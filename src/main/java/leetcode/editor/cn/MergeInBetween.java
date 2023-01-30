package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1669. 合并两个链表
 * @date 2023/1/30 11:53
 */
public class MergeInBetween {

    class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            ListNode pre = list1;
            //a之前的链
            for (int i = 0; i < a - 1; i++) {
                pre = pre.next;
            }
            //b之后的链
            ListNode tail = list1;
            for (int i = 0; i <= b; i++) {
                tail = tail.next;
            }
            //list2接到a之前的链上
            pre.next = list2;
            while (list2.next != null) {
                list2 = list2.next;
            }
            //尾巴接上
            list2.next = tail;
            return list1;
        }
    }
}
