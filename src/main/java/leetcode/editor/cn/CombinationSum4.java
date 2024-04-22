package leetcode.editor.cn;

//377. 组合总和 Ⅳ
public class CombinationSum4 {
    public static void main(String[] args) {
        CombinationSum4.Solution solution = new CombinationSum4().new Solution();
        int[] nums = {1, 2, 3};
        int target = 4;
        int res = solution.combinationSum4(nums, target);
        System.out.println(res);
    }

    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if (num <= i) {
                        dp[i] += dp[i - num];
                    }
                }
            }
            return dp[target];
        }
    }
}
