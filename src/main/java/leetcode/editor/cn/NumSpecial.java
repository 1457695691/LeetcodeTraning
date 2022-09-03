package leetcode.editor.cn;

/**
 * 1582. 二进制矩阵中的特殊位置
 *
 * @author Ayuan
 */
public class NumSpecial {
    /**
     * 思路: 两次遍历
     */
    class Solution {
        public int numSpecial(int[][] mat) {
            int[] row = new int[mat.length];
            int[] col = new int[mat[0].length];
            int res = 0;
            //1.第一次统计每行每列1的个数
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    row[i] += mat[i][j];
                    col[j] += mat[i][j];
                }
            }
            //2.第二次遍历查找特殊位置
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
