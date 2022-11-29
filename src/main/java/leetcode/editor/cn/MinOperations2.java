package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1758. 生成交替二进制字符串的最少操作数
 * @date 2022/11/29 10:08
 */
public class MinOperations2 {
    class Solution {
        /**
         * 所有的0和1的所在的下标的奇偶性都一样
         */
        public int minOperations(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != (char) ('0' + i % 2)) {
                    res++;
                }
            }
            return Math.min(res, s.length() - res);
        }
    }
}
