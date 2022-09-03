package leetcode.editor.cn;

/**
 * 1035. 不相交的线
 *
 * @author Ayuan
 */
public class MaxUncrossedLines {

    public static void main(String[] args) {
        MaxUncrossedLines.Solution solution = new MaxUncrossedLines().new Solution();
        int[] nums1 = {1, 1, 3, 5, 3, 3, 5, 5, 1, 1};
        int[] nums2 = {2, 3, 2, 1, 3, 5, 3, 2, 2, 1};
        int out = solution.maxUncrossedLines(nums1, nums2);
        System.out.println(out);
    }

    /**
     * 思路:DP动态规划
     * 最长公共子序列
     */
    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            //todo:优化->二维数组变一维
            int m = nums1.length, n = nums2.length;
            //数组nums1的前i个元素和nums2的前j个元素所能绘制的最大连接数
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
