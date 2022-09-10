package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1986. 完成任务的最少工作时间段
 * @date 2022/9/5 17:21
 */
public class MinSessions {
    public static void main(String[] args) {
        MinSessions.Solution solution = new MinSessions().new Solution();
        int[] tasks = {1, 2, 3};
        int out = solution.minSessions(tasks, 3);
        System.out.println(out);
    }

    /**
     * 思路：状态DP->暴力算所有情况取最优解 (1<<n)-1
     * Tips：以普遍理性而论，状压的数据范围都会小于 20。
     */
    class Solution {
        public int minSessions(int[] tasks, int sessionTime) {
            //状态定义f[i]： 达到状态f[i]的最少工作时间段
            int n = tasks.length, m = 1 << n;
            int[] f = new int[m];
            Arrays.fill(f, n);
            for (int i = 1; i < m; i++) {
                int cost = 0;
                for (int j = 0; j < n; j++) {
                    if (((i >> j) & 1) != 0) {
                        cost += tasks[j];
                    }
                }
                if (cost <= sessionTime) {
                    f[i] = 1;
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = i; j > 0; j = (j - 1) & i) {
                    //i ^ j, 就是i和j之间差的那一部分
                    f[i] = Math.min(f[i], f[j] + f[j ^ i]);
                }
            }

            return f[m - 1];
        }
    }
}
