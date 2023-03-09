package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2379. 得到 K 个黑块的最少涂色次数
 * @date 2023/3/9 09:40
 */
public class MinimumRecolors {

    class Solution {
        public int minimumRecolors(String blocks, int k) {
            int min = k;
            for (int i = 0; i <= blocks.length() - k; i++) {
                int count = (int) blocks.substring(i, i + k).chars().filter(c -> c == 'W').count();
                min = Math.min(min, count);
            }
            return min;
        }
    }
}
