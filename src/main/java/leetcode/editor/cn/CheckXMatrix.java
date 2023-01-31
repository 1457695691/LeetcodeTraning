package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 2319. 判断矩阵是否是一个 X 矩阵
 * @date 2023/1/31 09:37
 */
public class CheckXMatrix {

    class Solution {
        public boolean checkXMatrix(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                //1.判断对角线是否为0
                if (grid[i][i] == 0 || grid[i][grid.length - i - 1] == 0) {
                    return false;
                }
                //2.赋值对角线为0
                grid[i][i] = 0;
                grid[i][grid.length - i - 1] = 0;
            }
            //3.判断grip中元素是否都为0
            return Arrays.stream(grid).allMatch(i -> Arrays.stream(i).allMatch(j -> j == 0));
        }
    }

    class Solution2 {
        public boolean checkXMatrix(int[][] grid) {
            int n = grid.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //矩阵对角线上的所有元素都 不是 0
                    if ((i == j || i == n - 1 - j) && grid[i][j] == 0) return false;
                    //矩阵中所有其他元素都是 0
                    else if ((i != j && i != n - 1 - j) && grid[i][j] != 0) return false;
                }
            }
            return true;
        }
    }
}
