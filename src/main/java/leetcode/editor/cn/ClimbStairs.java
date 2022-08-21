package leetcode.editor.cn;

/**
 * 70. 爬楼梯
 *
 * @author Ayuan
 */
public class ClimbStairs {

    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
