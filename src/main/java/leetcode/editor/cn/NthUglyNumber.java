package leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. 丑数 II
 *
 * @author Ayuan
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        NthUglyNumber.Solution solution = new NthUglyNumber().new Solution();
        int out = solution.nthUglyNumber(10);
        System.out.println(out);
    }

    /**
     * 思路:优先队列最小堆
     */
    class Solution {
        public int nthUglyNumber(int n) {
            //1.构造一个优先队列
            //2.先把最小丑数扔队列里
            //3.取队列最小值x,然后2x.3x.5x也扔队列里
            //4.循环步骤3n次,出队的就是
            //5.set记一下如果队列的丑数
            Set<Long> set = new HashSet<>();
            PriorityQueue<Long> heap = new PriorityQueue<>();
            set.add(1L);
            heap.offer(1L);
            int[] nums = new int[]{2, 3, 5};
            while (n > 1) {
                Long x = heap.poll();
                for (int num : nums) {
                    Long m = num * x;
                    if (!set.contains(m)) {
                        set.add(m);
                        heap.offer(m);
                    }
                }
                n--;
            }
            return Math.toIntExact(heap.poll());
        }
    }
}
