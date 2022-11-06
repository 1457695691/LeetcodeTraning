package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1822. 数组元素积的符号
 * @date 2022/10/27 10:00
 */
public class ArraySign {
    class Solution {
        public int arraySign(int[] nums) {
            int res = 1;
            for (int num : nums) {
                if (num == 0) {
                    return 0;
                }
                if (num < 0) {
                    res *= -1;
                }
            }
            return res;
        }
    }
}
