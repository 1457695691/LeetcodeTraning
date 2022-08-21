package leetcode.editor.cn;

import java.util.Stack;

/**
 * 32. 最长有效括号
 *
 * @author Ayuan
 */
public class LongestValidParentheses {

    /**
     * 用栈去判断序列的合法性
     */
    class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> st = new Stack<Integer>();
            int ans = 0;
            for (int i = 0, start = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    st.push(i);
                } else {
                    if (!st.isEmpty()) {
                        st.pop();
                        if (st.isEmpty()) {
                            ans = Math.max(ans, i - start + 1);
                        } else {
                            ans = Math.max(ans, i - st.peek());
                        }
                    } else {
                        start = i + 1;
                    }
                }
            }
            return ans;
        }
    }
}
