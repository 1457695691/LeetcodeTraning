package leetcode.editor.cn;

import java.util.HashMap;

/**
 * @author Ayuan
 * @Description: 1124. 表现良好的最长时间段
 * @date 2023/2/14 09:41
 */
public class LongestWPI {

    class Solution {
        public int longestWPI(int[] hours) {
            int n = hours.length;
            int max = 0;
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; i++) arr[i + 1] = arr[i] + (hours[i] > 8 ? 1 : -1);
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (arr[i] > arr[j]) max = Math.max(max, i - j);
                }
            }
            return max;
        }
    }

    class Solution2 {
        public int longestWPI(int[] hours) {
            int n = hours.length, sum = 0, res = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                sum = sum + (hours[i] > 8 ? 1 : -1);
                if (sum <= 0) {
                    map.putIfAbsent(sum, i);
                    if (map.containsKey(sum - 1)) {
                        res = Math.max(res, i - map.get(sum - 1));
                    }
                } else {
                    res = i + 1;
                }
            }
            return res;
        }
    }

}
