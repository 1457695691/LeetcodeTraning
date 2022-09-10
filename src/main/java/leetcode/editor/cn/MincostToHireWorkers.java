package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 857. 雇佣 K 名工人的最低成本
 *
 * @author Ayuan
 */
public class MincostToHireWorkers {

    /**
     * 贪心+优先队列
     * 思路:先要一个能力最高工资最低的,然后要能力小的均衡一下k
     */
    class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            double res = Double.MAX_VALUE;
            //1.工人数量
            int workNumber = quality.length;
            //2.用一个二位数组存储工人的效率和工作量
            double[][] weight = new double[workNumber][2];
            //3.初始化效率数组 效率weight[i]= wage[i]/quality[i]
            for (int i = 0; i < workNumber; i++) {
                weight[i] = new double[]{(double) wage[i] / quality[i], quality[i]};
            }
            //4.按照工作效率升序排列
            Arrays.sort(weight, Comparator.comparingDouble(a -> a[0]));
            //5.定义优先队列和总工作量
            PriorityQueue<Double> queue = new PriorityQueue<>();
            double totalWork = 0.0D;
            for (int i = 0; i < workNumber; i++) {
                //6.计算当前工作量,并扔进优先队列里
                totalWork += weight[i][1];
                queue.offer(-weight[i][1]);
                //7.太多了就扔出来,这里存个负数好排序
                if (queue.size() > k) {
                    totalWork += queue.poll();
                }
                //9.找到数量对的工人了就扔进返回值
                if (queue.size() == k) {
                    //资本家思想:用最少的钱干最多活的人
                    res = Math.min(res, weight[i][0] * totalWork);
                }
            }
            return res;
        }
    }
}
