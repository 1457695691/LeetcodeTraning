package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2432. 处理用时最长的那个任务的员工
 * @date 2023/5/5 10:20
 */
public class HardestWorker {
    class Solution {
        public int hardestWorker(int n, int[][] logs) {
            int cur = logs[0][1], id = logs[0][0];
            for (int i = 1; i < logs.length; i++) {
                if (logs[i][1] - logs[i - 1][1] > cur) {
                    cur = logs[i][1] - logs[i - 1][1];
                    id = logs[i][0];
                } else if (logs[i][1] - logs[i - 1][1] == cur && logs[i][0] < id) {
                    id = logs[i][0];
                }
            }
            return id;
        }
    }
}
