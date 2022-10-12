package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ayuan
 * @Description: 817. 链表组件
 * @date 2022/10/12 09:11
 */
public class NumComponents {
    class Solution {
        public int numComponents(ListNode head, int[] nums) {
            int res = 0;
            //1.nums扔进set里去重
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            ListNode p = head;
            //2.遍历链表
            while (p != null) {
                //3.当前节点存在set里并且下个节点不存在set里或者达到链表尾部
                if (set.contains(p.val) && (p.next == null || !set.contains(p.next.val))) {
                    res++;
                }
                p = p.next;
            }
            return res;
        }
    }
}
