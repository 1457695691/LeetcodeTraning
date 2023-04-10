package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/4/7 10:06
 */
public class NumMovesStonesII {
    class Solution {
        public int[] numMovesStonesII(int[] stones) {
            //1.从小到大排序
            int n = stones.length;
            Arrays.sort(stones);
            //2.找最大值 = 初始左右两端还未占用的空间 - min(左边第1,2颗之间空隙,右边第1,2颗之间空隙)
            int max = stones[n - 1] - stones[0] + 1 - n - Math.min(stones[n - 1] - stones[n - 2] - 1, stones[1] - stones[0] - 1);
            int min = max;
            //3.找最小值 = n大小连续空间里初始有最多颗石头的情况(滑动n大小窗口)
            for (int i = 0; i < n; i++) {
                int j = i;
                while (j < n && stones[j] < stones[i] + n) {
                    j++;
                }
                //需要往stones[i]~stones[j]里移多少颗石头
                int cost = n - (j - i);
                //考虑特殊情况3,4,5,6,10,此时不能移10->7,而必须移3->8,10->7,故为两次
                if (j - 1 - i == n - 2 && stones[j - 1] - stones[i] == n - 2) {
                    cost = 2;
                }
                min = Math.min(min, cost);
            }
            return new int[]{min, max};
        }
    }
}
