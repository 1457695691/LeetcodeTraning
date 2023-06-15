package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 1177. 构建回文串检测
 * @date 2023/6/15 10:43
 */
public class CanMakePaliQueries {
    /**
     * 前缀和+异或
     */

    class Solution {
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            int n = s.length();
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int bit = 1 << (s.charAt(i) - 'a');
                sum[i + 1] = sum[i] ^ bit; // 该比特对应字母的奇偶性：奇数变偶数，偶数变奇数
            }
            List<Boolean> ans = new ArrayList<>(queries.length);
            for (int[] q : queries) {
                int left = q[0], right = q[1], k = q[2];
                int m = Integer.bitCount(sum[right + 1] ^ sum[left]);
                ans.add(m / 2 <= k);
            }
            return ans;
        }
    }
}
