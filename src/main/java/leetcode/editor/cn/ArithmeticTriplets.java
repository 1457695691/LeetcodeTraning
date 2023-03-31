package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2367. 算术三元组的数目
 * @date 2023/3/31 11:08
 */
public class ArithmeticTriplets {

    class Solution {
        public int arithmeticTriplets(int[] nums, int diff) {
            int n = nums.length;
            int res = 0;
            for (int i = 0, j = 1, k = 2; j < n - 1; ++j) {
                while (i < j - 1 && nums[j] - nums[i] > diff) ++i;
                while (k < n - 1 && nums[k] - nums[j] < diff) ++k;
                if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff)
                    ++res;
            }
            return res;
        }
    }
}
