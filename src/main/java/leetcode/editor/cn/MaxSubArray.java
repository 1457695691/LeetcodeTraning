package leetcode.editor.cn;

/**
 * 53. 最大子数组和
 *
 * @author Ayuan
 */
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray.Solution solution = new MaxSubArray().new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int out = solution.maxSubArray(nums);
        System.out.println(out);
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            //1.最大值max 累加和sum
            //2.遍历nums, 计算sum
            //3.加起来比最大值大了,正数给max
            //4.加起来比最大值小了,负数重新算
            int max = nums[0];
            int sum = 0;
            for (int num : nums) {
                sum += num;
                if (sum > max) {
                    max = sum;
                }
                if (sum < 0) {
                    sum = 0;
                }
            }
            return max;
        }
    }
}
