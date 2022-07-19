package leetcode.editor.cn;

import java.util.HashMap;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 010. 和为 k 的子数组
 * @date 2022/7/19 12:01
 */
public class SubarraySum {
    /**
     * 前缀和
     */

    public static void main(String[] args) {
        SubarraySum.Solution solution = new SubarraySum().new Solution();
        int[] nums = {1, 1, 1};
        int k = 2;
        int out = solution.subarraySum(nums, k);
        System.out.println(out);
    }

    class Solution {
        public int subarraySum(int[] nums, int k) {
            int pre_sum = 0;
            int ret = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            //数组nums[0]为开头的连续子数组
            map.put(0, 1);
            for (int i : nums) {
                pre_sum += i;
                ret += map.getOrDefault(pre_sum - k, 0);
                //判断当前的累加和是否在哈希表中，若存在value+1，若不存在value=1
                map.put(pre_sum, map.getOrDefault(pre_sum, 0) + 1);
            }
            return ret;
        }
    }
}
