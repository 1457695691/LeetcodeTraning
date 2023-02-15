package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1250. 检查「好数组」
 * @date 2023/2/15 10:07
 */
public class IsGoodArray {
    class Solution {
        public boolean isGoodArray(int[] nums) {
            return Arrays.stream(nums).reduce(this::gcd).getAsInt() == 1;
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }
}
