package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 2357. 使数组中所有元素都等于零
 * @date 2023/2/24 09:28
 */
public class MinimumOperations {

    class Solution {
        public int minimumOperations(int[] nums) {
            return (int) Arrays.stream(nums)
                    .filter(i -> i > 0)
                    .distinct()
                    .count();
        }
    }
}
