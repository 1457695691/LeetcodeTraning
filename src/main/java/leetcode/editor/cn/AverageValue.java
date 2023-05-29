package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 2455. 可被三整除的偶数的平均值
 * @date 2023/5/29 09:31
 */
public class AverageValue {
    class Solution {
        public int averageValue(int[] nums) {
            return (int) Arrays.stream(nums)
                    .filter(x -> x % 2 == 0 && x % 3 == 0)
                    .average().orElse(0);
        }
    }
}
