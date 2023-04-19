package leetcode.editor.cn;

import static java.lang.Math.max;

/**
 * @author Ayuan
 * @Description: 1043. 分隔数组以得到最大和
 * @date 2023/4/19 11:27
 */
public class MaxSumAfterPartitioning {
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length;
            int[] f = new int[n + 1];
            for (int i = 0; i < n; ++i) {
                for (int j = i, mx = 0; j > i - k && j >= 0; --j) {
                    mx = max(mx, arr[j]);
                    f[i + 1] = max(f[i + 1], f[j] + (i - j + 1) * mx);
                }
            }
            return f[n];
        }
    }
}
