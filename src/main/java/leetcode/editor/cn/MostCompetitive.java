package leetcode.editor.cn;

import java.util.Arrays;

public class MostCompetitive {
    public static void main(String[] args) {
        Solution solution = new MostCompetitive().new Solution();
        int[] nums = {3, 5, 2, 6};
        int k = 2;
        int[] res = solution.mostCompetitive(nums, k);
        System.out.println(Arrays.toString(res));
    }

    class Solution {
        public int[] mostCompetitive(int[] nums, int k) {
            k = nums.length - k;
            int[] res = new int[nums.length];
            int j = 0;
            for(int x: nums){
                while(j > 0 && k > 0 && x < res[j - 1]){
                    j --;
                    k --;
                }
                res[j ++] = x;
            }
            int[] ans = new int[j - k];
            System.arraycopy(res, 0, ans, 0, j - k);
            return ans;
        }
    }
}
