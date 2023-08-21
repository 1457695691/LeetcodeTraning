package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1388. 3n 块披萨
 * @date 2023/8/18 09:47
 */
public class MaxSizeSlices {

    class Solution {
        public int maxSizeSlices(int[] slices) {
            int n = slices.length;
            int[] dp = new int[n + 1];
            int max = 0;
            for (int i = n - 1; i >= 0; i--) {
                dp[i] = Math.max(dp[i + 1], slices[i] + (i + 1 < n ? dp[i + 2] : 0));
                max = Math.max(max, dp[i]);
            }
            return max;
        }

    }
}
