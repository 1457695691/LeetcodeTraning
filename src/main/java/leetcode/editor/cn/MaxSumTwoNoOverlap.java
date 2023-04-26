package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1031. 两个非重叠子数组的最大和
 * @date 2023/4/26 09:59
 */
public class MaxSumTwoNoOverlap {
    class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            //双滑窗,维护前缀和
            int n = nums.length;
            int[] preSum = new int[n + 1];
            int res = 0;
            //计算前缀和
            for (int i = 1; i <= n; ++i) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            for (int i = firstLen; i <= n; ++i) {
                int first = preSum[i] - preSum[i - firstLen];
                //计算在i-firstLen的左边和i的右边M的最大值
                int second = 0;
                for (int j = secondLen; j <= i - firstLen; ++j) {
                    second = Math.max(second, preSum[j] - preSum[j - secondLen]);
                }
                for (int j = i + 1; j <= n - secondLen; ++j) {
                    second = Math.max(second, preSum[j + secondLen] - preSum[j]);
                }
                res = Math.max(first + second, res);
            }
            return res;
        }
    }
}
