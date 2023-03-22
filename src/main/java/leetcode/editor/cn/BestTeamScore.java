package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1626. 无矛盾的最佳球队
 * @date 2023/3/22 11:09
 */
public class BestTeamScore {

    class Solution {
        public int bestTeamScore(int[] scores, int[] ages) {
            int n = scores.length, maximum = 0;
            int[][] candidate = new int[n][2];
            for (int i = 0; i < n; i++) {
                candidate[i][0] = ages[i];
                candidate[i][1] = scores[i];
            }
            Arrays.sort(candidate, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = candidate[i][1];
                for (int j = 0; j < i; j++) {
                    if (candidate[i][1] <= candidate[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + candidate[i][1]);
                    }
                }
                maximum = Math.max(maximum, dp[i]);
            }
            return maximum;
        }
    }
}
