package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 1224. 最大相等频率
 *
 * @author Ayuan
 */
public class MaxEqualFreq {
    public static void main(String[] args) {
        MaxEqualFreq.Solution solution = new MaxEqualFreq().new Solution();
        int[] nums = {2, 2, 1, 1, 5, 3, 3, 5};
        int out = solution.maxEqualFreq(nums);
        System.out.println(out);
    }

    class Solution {
        public int maxEqualFreq(int[] nums) {
            int[] elementTimes = new int[100001];
            int[] timesGroup = new int[100001];
            Arrays.fill(elementTimes, 0);
            Arrays.fill(timesGroup, 0);
            int maxLength = 0, maxTimes = 0;

            for (int i = 0; i < nums.length; i++) {
                int num = elementTimes[nums[i]];
                elementTimes[nums[i]] += 1;
                if (num > 0) {
                    timesGroup[num] += -1;
                }
                timesGroup[num + 1] += 1;
                maxTimes = Math.max(maxTimes, num + 1);
                //所有元素均出现1次
                if (timesGroup[1] == i + 1 ||
                        //只有1个元素出现N次 以及 多个出现N次和1个出现N+1次元素
                        (timesGroup[maxTimes] == 1 && maxTimes + timesGroup[maxTimes - 1] * (maxTimes - 1) == i + 1) ||
                        //去除1个元素，就满足"最大出现次数"*"元素个数"
                        timesGroup[maxTimes] * maxTimes == i) {
                    maxLength = i + 1;
                }
            }
            return maxLength;
        }
    }
}
