package leetcode.editor.cn;

import com.sun.source.tree.BreakTree;

import java.util.HashMap;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * @date 2022/7/19 12:15
 */
public class FindMaxLength {
    public static void main(String[] args) {
        FindMaxLength.Solution solution = new FindMaxLength().new Solution();
        int[] nums = {0, 1, 0};
        int out = solution.findMaxLength(nums);
        System.out.println(out);
    }

    class Solution {
        public int findMaxLength(int[] nums) {
            int pre_sum = 0;
            int ret = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            for (int i = 0; i < nums.length; i++) {
                pre_sum += nums[i] == 0 ? -1 : 1;
                if (map.containsKey(pre_sum)) {
                    ret = Math.max(ret, i - map.get(pre_sum));
                } else {
                    map.put(pre_sum, i);
                }
            }
            return ret;
        }
    }
}
