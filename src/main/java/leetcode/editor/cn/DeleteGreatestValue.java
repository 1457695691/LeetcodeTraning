package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 2500. 删除每行中的最大值
 * @date 2022/12/12 16:20
 */
public class DeleteGreatestValue {
    class Solution {
        public int deleteGreatestValue(int[][] grid) {
            //1.行按大小排序
            for (int[] i : grid) {
                Arrays.sort(i);
            }
            //2.定义返回值
            int sum = 0;
            //3.因为已经每行都排好序了，所以每一列取最大值相加就行了
            for (int i = 0; i < grid[0].length; i++) {
                int max = 0;
                for (int[] its : grid) {
                    max = Math.max(max, its[i]);
                }
                sum += max;
            }
            return sum;
        }
    }
}
