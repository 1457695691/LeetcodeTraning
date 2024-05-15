package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2589. 完成所有任务的最少时间
 */
public class FindMinimumTime {
    public static void main(String[] args) {
        Solution solution = new FindMinimumTime().new Solution();
        int[][] tasks = {{2, 3, 1}, {4, 5, 1}, {1, 5, 2}};
        int res = solution.findMinimumTime(tasks);
        System.out.println(res);
    }

    class Solution {
        public int findMinimumTime(int[][] tasks) {
            int res = 0;
            //按照区间右端点从小到大排序，取右端点最大值
            Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
            int mx = tasks[tasks.length - 1][1];

            boolean[] run = new boolean[mx + 1];

            for (int[] task : tasks) {
                int start = task[0];
                int end = task[1];
                int duration = task[2];

                for (int i = start; i <= end; i++) {
                    if (run[i]) {
                        duration--;
                    }
                }

                for (int i = end; duration > 0; i--) {
                    if (!run[i]) {
                        run[i] = true;
                        duration--;
                        res++;
                    }
                }
            }

            return res;
        }
    }
}
