package leetcode.editor.cn;


import java.util.Arrays;
import java.util.Comparator;

public class CountWays {

    public static void main(String[] args) {
        CountWays.Solution solution = new CountWays().new Solution();
        int[][] ranges = {{1, 3}, {10, 20}, {2, 5}, {4, 8}};
        int result = solution.countWays(ranges);
        System.out.println(result);
    }

    class Solution {
        public int countWays(int[][] ranges) {
            int res = 2;
            Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
            int maxR = ranges[0][1];
            for (int i = 1; i < ranges.length; i++) {
                int left = ranges[i][0];
                int right = ranges[i][1];
                if (left > maxR) {
                    res = (res * 2) % 1000000007;
                }
                maxR = Math.max(maxR, right);
            }
            return res;
        }
    }
}
