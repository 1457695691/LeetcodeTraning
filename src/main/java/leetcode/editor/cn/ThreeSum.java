package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 007. 数组中和为 0 的三个数
 * @date 2022/7/18 16:23
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum.Solution solution = new ThreeSum().new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> out = solution.threeSum(nums);
        System.out.println(out);
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (null == nums || 3 > nums.length) {
                return new ArrayList<>();
            }
            Arrays.sort(nums);
            //存储一个旧值来去重
            int lastNum = Integer.MAX_VALUE;
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == lastNum) {
                    continue;
                }
                lastNum = nums[i];
                //双指针开始  b+c = -a
                int left = i + 1;
                int right = nums.length - 1;
                int target = -nums[i];
                int sum;
                while (left < right) {
                    sum = nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(lastNum, nums[left], nums[right]));
                        ++left;
                        //去重优化
                        while (left < right && nums[left] == nums[left - 1]) {
                            ++left;
                        }
                        --right;
                        while (left < right && nums[right] == nums[right + 1]) {
                            --right;
                        }
                    } else if (sum > target) {
                        --right;
                    } else {
                        ++left;
                    }
                }
            }
            return result;
        }
    }
}
