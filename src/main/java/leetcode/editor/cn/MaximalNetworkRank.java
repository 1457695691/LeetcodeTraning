package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1615. 最大网络秩
 * @date 2023/3/15 09:57
 */
public class MaximalNetworkRank {
    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            //初始化数组
            int[][] grid = new int[n][n];
            int[] degree = new int[n];
            int res = 0;
            for (int[] road : roads) {
                grid[road[0]][road[1]] = grid[road[1]][road[0]] = 1;
                degree[road[0]]++;
                degree[road[1]]++;
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int cur = degree[i] + degree[j];
                    if (grid[i][j] == 1 || grid[j][i] == 1) {
                        cur--;
                    }
                    res = Math.max(res, cur);
                }
            }
            return res;
        }
    }
}
