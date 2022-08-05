package leetcode.editor.cn;


/**
 * @author Ayuan
 * @Description: 剑指 Offer II 012. 左右两边子数组的和相等
 * @date 2022/7/19 12:24
 */
public class PivotIndex {
    public static void main(String[] args) {
        PivotIndex.Solution solution = new PivotIndex().new Solution();
        int[] nums = {2, 1, -1};
        int out = solution.pivotIndex(nums);
        System.out.println(out);
    }

    class Solution {
        public int pivotIndex(int[] nums) {
            int[] preSum = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                preSum[i] = sum;
            }
            for (int i = 0; i < nums.length; i++) {
                int left = i > 0 ? preSum[i - 1] : 0;
                int right = sum - preSum[i];
                if (left == right) {
                    return i;
                }
            }
            return -1;
        }
    }
}
