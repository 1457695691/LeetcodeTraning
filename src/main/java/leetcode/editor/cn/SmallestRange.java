package leetcode.editor.cn;

import java.util.*;

/**
 * 632. 最小区间
 *
 * @author Ayuan
 */
public class SmallestRange {

    public static void main(String[] args) {
        SmallestRange.Solution solution = new SmallestRange().new Solution();
        List<List<Integer>> nums = new ArrayList<List<Integer>>(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)));
        int[] out = solution.smallestRange(nums);
        System.out.println(Collections.singletonList(out).toString());
    }

    /**
     * 整体思路:贪心+小根堆
     * 问题可以转换成->取元素差值最小的区间,区间内必须包含K个数组里至少一个值
     */
    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            //1.定义区间范围min,max,小根堆heap
            //2.k个区间各取一个最小值扔进heap里,同时记录min,max
            //3.取heap里最min所在list,找到他的下一个元素,扔进heap里,更新min和max的值
            //4.循环步骤3,得到min,max区间范围
            PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.size(); i++) {
                //堆内数据: list最小值,在第几个list,在list里什么位置
                heap.offer(new int[]{nums.get(i).get(0), i, 0});
                max = Math.max(nums.get(i).get(0), max);
            }
            int resMin = heap.peek()[0];
            int resMax = max;
            int range = max - resMin;
            while (!heap.isEmpty()) {
                int[] cur = heap.poll();
                int index = cur[1], next = cur[2] + 1;
                List<Integer> curList = nums.get(index);
                if (curList.size() == next) {
                    break;
                }
                Integer nextNum = curList.get(next);
                heap.offer(new int[]{nextNum, index, next});
                max = Math.max(max, nextNum);
                if (max - heap.peek()[0] < range) {
                    range = max - heap.peek()[0];
                    resMin = heap.peek()[0];
                    resMax = max;
                }
            }
            return new int[]{resMin, resMax};
        }
    }
}
