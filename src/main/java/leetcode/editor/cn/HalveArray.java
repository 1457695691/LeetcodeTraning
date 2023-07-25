package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Ayuan
 * @Description: 2208. 将数组和减半的最少操作次数
 * @date 2023/7/25 09:26
 */
public class HalveArray {
    class Solution {
        public int halveArray(int[] nums) {
            double sum = 0.0;
            Queue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int num : nums) {
                sum += num;
                queue.add((double) num);
            }
            sum /= 2;
            int ans = 0;
            while (sum > 0) {
                double d = queue.poll();
                sum -= d / 2;
                queue.add(d / 2);
                ans++;
            }
            return ans;
        }
    }
}
