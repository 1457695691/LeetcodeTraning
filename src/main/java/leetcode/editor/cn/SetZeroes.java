package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ayuan
 * @Description: 面试题 01.08. 零矩阵
 * @date 2022/9/30 10:02
 */
public class SetZeroes {
    class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            //标记0所在的行和列
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        row.add(i);
                        col.add(j);
                    }
                }
            }
            //对应行和列清零
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (row.contains(i) || col.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
