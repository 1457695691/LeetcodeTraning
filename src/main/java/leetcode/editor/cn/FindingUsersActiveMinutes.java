package leetcode.editor.cn;

import java.util.*;

/**
 * @author Ayuan
 * @Description: 1817. 查找用户活跃分钟数
 * @date 2023/1/20 09:22
 */
public class FindingUsersActiveMinutes {
    class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {
            int[] res = new int[k];
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] log : logs) {
                if (!map.containsKey(log[0])) {
                    map.put(log[0], new HashSet<>());
                }
                map.get(log[0]).add(log[1]);
            }
            for (Set<Integer> value : map.values()) {
                res[value.size() - 1]++;
            }
            return res;
        }
    }
}
