package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author Ayuan
 */
public class FindKthLargest {


    /**
     * 思路：优先队列就是用小顶堆构建的，可以直接使用
     */
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            //1.维护length为k的小顶堆
            //2.遍历nums,入队就弹出最小元素,遍历完堆顶元素自然是第k大的数
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int num : nums) {
                heap.offer(num);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            return heap.peek();

        }
    }
}
