package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1139. 最大的以 1 为边界的正方形
 * @date 2023/2/17 09:33
 */
public class Largest1BorderedSquare {

    /**
     * 前缀和
     */
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] rs = new int[m][n + 1]; // 每行的前缀和
            int[][] cs = new int[n][m + 1]; // 每列的前缀和
            //初始化前缀和数组
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rs[i][j + 1] = rs[i][j] + grid[i][j];
                    cs[j][i + 1] = cs[j][i] + grid[i][j];
                }
            }
            // 从大到小枚举正方形边长 d
            for (int d = Math.min(m, n); d > 0; --d) {
                // 枚举正方形左上角坐标 (i,j)
                for (int i = 0; i <= m - d; ++i) {
                    for (int j = 0; j <= n - d; ++j) {
                        if (rs[i][j + d] - rs[i][j] == d && // 上边
                                cs[j][i + d] - cs[j][i] == d && // 左边
                                rs[i + d - 1][j + d] - rs[i + d - 1][j] == d && // 下边
                                cs[j + d - 1][i + d] - cs[j + d - 1][i] == d)   // 右边
                            return d * d;
                    }
                }
            }
            return 0;
        }
    }
}
