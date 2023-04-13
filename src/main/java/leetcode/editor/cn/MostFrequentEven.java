package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Ayuan
 * @Description: 2404. 出现最频繁的偶数元素
 * @date 2023/4/13 10:20
 */
public class MostFrequentEven {
    class Solution {
        public int mostFrequentEven(int[] nums) {
            Map<Integer, Integer> cnt = new HashMap<>();
            int res = -1;
            for (int n : nums) {
                if (n % 2 != 0) continue;
                cnt.put(n, cnt.getOrDefault(n, 0) + 1);
                if (res == -1 ||
                        cnt.get(n) > cnt.get(res) ||
                        (n < res && Objects.equals(cnt.get(n), cnt.get(res)))) {
                    res = n;
                }
            }
            return res;
        }
    }
}
