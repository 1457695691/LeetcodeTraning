package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ayuan
 * @Description: 349. 两个数组的交集
 * @date 2022/9/23 13:57
 */
public class Intersection {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) {
                return new int[]{};
            }
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums1) {
                set.add(num);
            }
            Set<Integer> list = new HashSet<>();
            for (int num : nums2) {
                if (set.contains(num)) {
                    list.add(num);
                }
            }
            return list.stream().mapToInt(t -> t).toArray();
        }
    }
}
