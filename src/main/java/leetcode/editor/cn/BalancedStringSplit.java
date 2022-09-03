package leetcode.editor.cn;

/**
 * 1221. 分割平衡字符串
 *
 * @author Ayuan
 */
public class BalancedStringSplit {

    /**
     * 思路:贪心
     */
    class Solution {
        public int balancedStringSplit(String s) {
            int res = 0, cnt = 0;
            for (char c : s.toCharArray()) {
                cnt += c == 'L' ? 1 : -1;
                if (cnt == 0) {
                    res++;
                }
            }
            return res;
        }
    }
}
