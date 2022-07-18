package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 004. 只出现一次的数字
 * @date 2022/7/18 09:29
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber.Solution solution = new SingleNumber().new Solution();
    }

    class Solution {
        public int singleNumber(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>(16);
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return 0;
        }
    }
}
