package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 1260. 二维网格迁移
 * @date 2022/7/20 09:41
 */
public class ShiftGrid {

    public static void main(String[] args) {
        ShiftGrid.Solution solution = new ShiftGrid().new Solution();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        List<List<Integer>> out = solution.shiftGrid(grid, k);
        System.out.println(out.toString());
    }


    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            List res = new ArrayList<>();
            int m = grid.length;
            if (m == 0) {
                return res;
            }
            int n = grid[0].length;
            int[][] ans = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans[(i + (j + k) / n) % m][(j + k) % n] = grid[i][j];
                }
            }
            res = Arrays.asList(ans);
            return res;
        }
    }
}
