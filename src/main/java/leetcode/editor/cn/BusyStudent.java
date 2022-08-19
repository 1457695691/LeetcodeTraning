package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2022/8/19 10:41
 */
public class BusyStudent {
    public static void main(String[] args) {
        BusyStudent.Solution solution = new BusyStudent().new Solution();
        int[] startTime = {1, 2, 3};
        int[] endTime = {3, 2, 7};
        int queryTime = 4;
        int out = solution.busyStudent(startTime, endTime, queryTime);
        System.out.println(out);
    }

    class Solution {
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int ans = 0;
            for (int i = 0; i < startTime.length; i++) {
                if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
