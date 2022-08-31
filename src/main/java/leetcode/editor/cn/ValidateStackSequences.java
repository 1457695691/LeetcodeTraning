package leetcode.editor.cn;

import java.util.Stack;

/**
 * @author Ayuan
 * @Description: 946. 验证栈序列
 * @date 2022/8/31 09:40
 */
public class ValidateStackSequences {
    public static void main(String[] args) {
        ValidateStackSequences.Solution solution = new ValidateStackSequences().new Solution();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 1, 2};
        boolean out = solution.validateStackSequences(pushed, popped);
        System.out.println(out);
    }

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int index = 0;
            for (int push : pushed) {
                stack.push(push);
                while (!stack.isEmpty() && stack.peek() == popped[index]) {
                    stack.pop();
                    index++;
                }
            }
            return stack.isEmpty();
        }
    }
}
