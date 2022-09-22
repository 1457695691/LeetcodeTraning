package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 698. 划分为k个相等的子集
 * @date 2022/9/20 15:31
 */
public class CanPartitionKSubsets {

    public static void main(String[] args) {
        CanPartitionKSubsets.Solution solution = new CanPartitionKSubsets().new Solution();
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        boolean out = solution.canPartitionKSubsets(nums, k);
        //True
        System.out.println(out);
    }

    /**
     * 思路：回溯
     */
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            //1.nums数组升序排序
            Arrays.sort(nums);
            //2.sum(nums)计算总和是多少
            int sum = Arrays.stream(nums).sum();
            //3.排除有小数的情况；除以k计算每组的值是多少，排除大于nums里最大值的情况
            if (sum % k != 0 || nums[nums.length - 1] > sum / k) {
                return false;
            }
            //4.开始分组匹配
            return backtrack(nums, sum / k, new int[k], nums.length - 1);
        }

        private boolean backtrack(int nums[], int target, int[] bucket, int index) {
            //1.结束条件
            if (index == -1) {
                return true;
            }
            //2.分成K个桶，回溯搜索
            for (int i = 0; i < bucket.length; i++) {
                //2.1 如果当前搜索的值加上桶里的值大于target，跳过
                if (nums[index] + bucket[i] > target) {
                    continue;
                }
                //2.2 如果桶里上一个值符合要求就返回true了，所以这种情况也得跳过
                if (i > 0 && bucket[i] == bucket[i - 1]) {
                    continue;
                }
                //2.3 累加桶里的值
                bucket[i] += nums[index];
                //2.4 递归
                if (backtrack(nums, target, bucket, index - 1)) {
                    return true;
                }
                //2.5 回溯
                bucket[i] -= nums[index];
            }
            //3.遍历完桶都找不到合适的
            return false;
        }
    }
}
