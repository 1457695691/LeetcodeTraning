package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ayuan
 * @Description: 849. 到最近的人的最大距离
 * @date 2023/8/22 09:28
 */
public class MaxDistToClosest {
    class Solution {
        public int maxDistToClosest(int[] seats) {
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < seats.length; i++) {
                if (seats[i] == 1) {
                    queue.add(i);
                }
            }
            int distance = queue.peek();
            while (queue.size() > 1) {
                int a = queue.pop();
                int b = queue.peek();
                distance = Math.max(distance, (b - a) / 2);
            }
            distance = Math.max(distance, seats.length - 1 - queue.peek());
            return distance;
        }
    }
}
