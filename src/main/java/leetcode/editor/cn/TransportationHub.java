package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: LCP 62. 交通枢纽
 * @date 2023/4/4 14:10
 */
public class TransportationHub {
    class Solution {
        public int transportationHub(int[][] path) {
            //返回入度 = n，并且出度 = 0的节点
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] p : path) {
                map.put(p[0], map.getOrDefault(p[0], 0) - 1);
                map.put(p[1], map.getOrDefault(p[1], 0) + 1);
            }
            int sum = map.size();
            for (Integer i : map.keySet()) {
                if (map.get(i) == sum - 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}
