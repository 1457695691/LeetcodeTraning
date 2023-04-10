package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ayuan
 * @Description: 1019. 链表中的下一个更大节点
 * @date 2023/4/10 11:02
 */
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (ListNode node = head; node != null; node = node.next) {
            while (!stack.isEmpty() && node.val > list.get(stack.peek())) {
                list.set(stack.pop(), node.val);
            }
            stack.push(list.size());
            list.add(node.val);
        }
        for (int i : stack) {
            list.set(i, 0);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
