package leetcode.editor.cn;

/**
 * 2960.统计已测试设备
 */
public class CountTestedDevices {
    public static void main(String[] args) {
        Solution solution = new CountTestedDevices().new Solution();
        int[] batteryPercentages = {1, 1, 2, 1, 3};
        int res = solution.countTestedDevices(batteryPercentages);
        System.out.println(res);
    }

    class Solution {
        public int countTestedDevices(int[] batteryPercentages) {
            int res = 0;
            for (int batteryPercentage : batteryPercentages) {
                if (batteryPercentage > res) {
                    res++;
                }
            }
            return res;
        }
    }
}
