package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 1403. 非递增顺序的最小子序列
 * @date 2022/8/4 10:05
 */
public class MinSubsequence {
    public static void main(String[] args) {
        MinSubsequence.Solution solution = new MinSubsequence().new Solution();
        int[] nums = {4, 3, 10, 9, 8};
        List<Integer> out = solution.minSubsequence(nums);
        System.out.println(out);
    }

    class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            Arrays.sort(nums);
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int s = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                s += nums[i];
                ans.add(nums[i]);
                if (s * 2 > sum) {
                    break;
                }
            }
            return ans;
        }
    }
}
