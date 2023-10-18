package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Ayuan
 * @Description: 2530. 执行 K 次操作后的最大分数
 * @date 2023/10/18 10:48
 */
public class MaxKelements {
    class Solution {
        public long maxKelements(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            PriorityQueue<Integer> dump = new PriorityQueue<>(Comparator.reverseOrder());
            for (int num : nums) {
                dump.add(num);
            }
            long res = 0;
            for (int i = 0; i < k; i++) {
                int val = dump.poll();
                res += val;
                dump.add(new Double(Math.ceil((double) val / 3)).intValue());
            }
            return res;
        }
    }
}
