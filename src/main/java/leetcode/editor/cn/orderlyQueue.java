package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 899. 有序队列
 * @date 2022/8/3 09:53
 */
public class orderlyQueue {
    public static void main(String[] args) {
        orderlyQueue.Solution solution = new orderlyQueue().new Solution();
        String out = solution.orderlyQueue("bbacd", 1);
        System.out.println(out);
    }

    class Solution {
        public String orderlyQueue(String s, int k) {
            char[] array = s.toCharArray();
            if (k > 1) {
                Arrays.sort(array);
                return String.valueOf(array);
            }
            StringBuilder stringBuilder = new StringBuilder(s);
            String ans = s;
            for (int i = 0; i < s.length(); i++) {
                char c = stringBuilder.charAt(0);
                stringBuilder.deleteCharAt(0);
                stringBuilder.append(c);
                if (stringBuilder.toString().compareTo(ans) < 0) {
                    ans = stringBuilder.toString();
                }
            }
            return ans;
        }
    }
}
