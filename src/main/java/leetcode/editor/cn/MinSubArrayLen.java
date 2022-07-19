package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * @date 2022/7/18 16:52
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen.Solution solution = new MinSubArrayLen().new Solution();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int out = solution.minSubArrayLen(target, nums);
        System.out.println(out);
    }

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            //滑动窗口
            int left = 0;
            int total = 0;
            int ret = Integer.MAX_VALUE;
            for (int right = 0; right < nums.length; right++) {
                total += nums[right];
                while (total >= target) {
                    ret = Math.min(ret, right - left + 1);
                    total -= nums[left++];
                }
            }
            return ret > nums.length ? 0 : ret;
        }
    }
}
