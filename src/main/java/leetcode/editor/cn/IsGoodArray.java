package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/2/15 10:07
 */
public class IsGoodArray {
    class Solution {
        public boolean isGoodArray(int[] nums) {
            int res = nums[0];
            for (int num : nums) {
                res = gcd(res, num);
                if (res == 1) break;
            }
            return res == 1;
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            if (b > a) return gcd(b, a);
            return gcd(b, a % b);
        }
    }
}
