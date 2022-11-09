package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 764. 最大加号标志
 * @date 2022/11/9 14:36
 */
public class OrderOfLargestPlusSign {
    /**
     * 暴力模拟+遍历
     */
    class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            int[][] grid = new int[n][n];
            int res = 0;
            //模拟填充数组
            for (int[] mine : mines) {
                grid[mine[0]][mine[1]] = 1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res = Math.max(res, find(grid, i, j, n));
                }
            }
            return res;
        }

        private int find(int[][] grid, int i, int j, int n) {
            if (grid[i][j] == 1) {
                return 0;
            }
            int k = 1;
            while (i - k >= 0 &&
                    grid[i - k][j] != 1 &&
                    i + k != n &&
                    grid[i + k][j] != 1 &&
                    j - k >= 0 &&
                    grid[i][j - k] != 1 &&
                    j + k != n &&
                    grid[i][j + k] != 1) {
                k++;
            }
            return k;
        }


    }
}
