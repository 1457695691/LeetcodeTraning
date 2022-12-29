package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 2032. 至少在两个数组中出现的值
 * @date 2022/12/29 10:37
 */
public class TwoOutOfThree {
    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for (int i : nums1) {
                Integer v = map.get(i);
                if (v == null) {
                    v = 1;
                }
                map.put(i, v);
            }
            for (int j : nums2) {
                Integer v = map.get(j);
                if (v == null) {
                    v = 2;
                } else if (v == 1) {
                    list.add(j);
                    v = 12;
                }
                map.put(j, v);
            }
            for (int j : nums3) {
                Integer v = map.get(j);
                if (v == null) {
                    v = 3;
                } else if (v == 1) {
                    list.add(j);
                    v = 13;
                } else if (v == 2) {
                    list.add(j);
                    v = 23;
                } else if (v == 12) {
                    v = 123;
                }
                map.put(j, v);
            }
            return list;
        }
    }
}
