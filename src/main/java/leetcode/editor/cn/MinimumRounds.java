package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2244. 完成所有任务需要的最少轮数
 */
public class MinimumRounds {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        int res = solution.minimumRounds(tasks);
        System.out.println(res);
    }


    static class Solution {
        public int minimumRounds(int[] tasks) {
            int count = 0;
            //k:tasks[i]; v: nums
            Map<Integer, Integer> map = new HashMap<>();
            Arrays.stream(tasks).forEach(key -> map.merge(key, 1, Integer::sum));
            for (Integer key : map.keySet()) {
                Integer value = map.get(key);
                //排除只有一个的情况
                if (1 == value) return -1;
                count += (value + 2) / 3;
            }
            return count;
        }
    }
}
