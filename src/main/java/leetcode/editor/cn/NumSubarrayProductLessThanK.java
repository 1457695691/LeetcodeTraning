package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 009. 乘积小于 K 的子数组
 * @date 2022/7/18 17:54
 */
public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        NumSubarrayProductLessThanK.Solution solution = new NumSubarrayProductLessThanK().new Solution();
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        int out = solution.numSubarrayProductLessThanK(nums, k);
        System.out.println(out);
    }

    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {

            int ret = 0;
            int left = 0;
            for (int i = 0; i < nums.length; i++) {
                int right = i;
                int sum = nums[i];
                while (sum < k){
                    ret++;
                    right++;
                    if (right >= nums.length){
                        break;
                    }
                    sum *= nums[right];
                }
            }
            return ret;
        }
    }
}
