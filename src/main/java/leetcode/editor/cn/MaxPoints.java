package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 2503. 矩阵查询可获得的最大分数
 * @date 2022/12/12 17:22
 */
public class MaxPoints {

    public static void main(String[] args) {
        MaxPoints.Solution solution = new MaxPoints().new Solution();
        int[][] grid = {{1, 2, 3}, {2, 5, 7}, {3, 5, 1}};
        int[] queries = {5, 6, 2};
        int[] out = solution.maxPoints(grid, queries);
        System.out.println(Arrays.toString(out));
    }


    /**
     * BFS硬写
     */
    class Solution {
        public int[] maxPoints(int[][] grid, int[] queries) {
            int n = queries.length;
            int[] answer = new int[n];


            return answer;
        }
    }
}
