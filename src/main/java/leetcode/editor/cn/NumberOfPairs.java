package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ayuan
 * @Description: 2341. 数组能形成多少数对
 * @date 2023/2/16 09:40
 */
public class NumberOfPairs {
    class Solution {
        public int[] numberOfPairs(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            for (int num : nums) {
                if (set.contains(num)) {
                    sum++;
                    set.remove(num);
                } else {
                    set.add(num);
                }
            }
            return new int[]{sum, nums.length - 2 * sum};
        }
    }
}
