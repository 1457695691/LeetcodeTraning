package leetcode.editor.cn;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * @author Ayuan
 * @Description: 1781. 所有子字符串美丽值之和
 * @date 2022/12/12 09:22
 */
public class BeautySum {
    public static void main(String[] args) {
        BeautySum.Solution solution = new BeautySum().new Solution();
        int out = solution.beautySum("aabcbaa");
        System.out.println(out);
    }


    class Solution {
        public int beautySum(String s) {
            char[] cs = s.toCharArray();
            int n = cs.length;

            int sum = 0;
            for (int i = 0; i < n - 2; i++) {
                int[] arr = new int[26];
                for (int j = i; j < n; j++) {
                    arr[cs[j] - 'a']++;
                    IntSummaryStatistics statistics = Arrays.stream(arr)
                            .filter(x -> x > 0)
                            .summaryStatistics();
                    sum += statistics.getMax() - statistics.getMin();
                }
            }
            return sum;
        }
    }
}
