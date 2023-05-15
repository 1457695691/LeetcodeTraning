package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 1072. 按列翻转得到最大值等行数
 * @date 2023/5/15 09:34
 */
public class MaxEqualRowsAfterFlips {

    public static void main(String[] args) {
        MaxEqualRowsAfterFlips.Solution solver = new MaxEqualRowsAfterFlips().new Solution();
        int[][] matrix = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(solver.maxEqualRowsAfterFlips(matrix));
    }


    class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            Map<String, Integer> cnt = new HashMap<>();
            int ans = 0, n = matrix[0].length;
            for (int[] row : matrix) {
                char[] cs = new char[n];
                for (int i = 0; i < n; i++) {
                    cs[i] = (char) (row[0] ^ row[i]);
                }
                ans = Math.max(ans, cnt.merge(String.valueOf(cs), 1, Integer::sum));
            }
            return ans;
        }
    }
}

