package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 2501. 数组中最长的方波
 * @date 2022/12/12 16:34
 */
public class LongestSquareStreak {
    class Solution {
        public int longestSquareStreak(int[] nums) {
            //1.定义返回值，先排序，再定义一个map
            int res = -1;
            Arrays.sort(nums);
            Map<Integer, Boolean> map = new HashMap<>();
            //2.把元素保存到map中
            for (int num : nums) {
                map.put(num, false);
            }
            //3.暴力匹配
            for (int num : nums) {
                int len = 1;
                int value = num;
                if (!map.get(value)) {
                    while (!map.isEmpty() && map.containsKey(value * value)) {
                        value = value * value;
                        map.put(value, true);
                        len++;
                        res = Math.max(res, len);
                    }
                }
            }
            return res;
        }
    }
}
