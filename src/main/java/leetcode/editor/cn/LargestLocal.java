package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2373. 矩阵中的局部最大值
 * @date 2023/3/1 09:51
 */
public class LargestLocal {

    // 池化
    class Solution {
        public int[][] largestLocal(int[][] grid) {
            int n = grid.length;
            int[][] maxLocal = new int[n - 2][n - 2];
            for (int i = 0; i < n - 2; i++) {
                for (int j = 0; j < n - 2; j++) {
                    int maxn = 0;
                    for (int p = i; p <= i + 2; p++) {
                        for (int q = j; q <= j + 2; q++) {
                            maxn = Math.max(maxn, grid[p][q]);
                        }
                    }
                    maxLocal[i][j] = maxn;
                }
            }
            return maxLocal;
        }
    }
}
