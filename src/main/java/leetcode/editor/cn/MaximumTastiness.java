package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 2517. 礼盒的最大甜蜜度
 * @date 2023/6/1 10:29
 */
public class MaximumTastiness {

    /**
     * 贪心+二分
     */
    class Solution {
        public int maximumTastiness(int[] price, int k) {
            //1.从小到大排序
            int n = price.length;
            Arrays.sort(price);
            //2.二分查找模版，右边界定义为最大差值
            int left = 0, right = price[n - 1] - price[0];
            while (left < right) {
                int mid = (left + right + 1) / 2;
                //3.贪心算法
                if (greedy(price, k, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        /**
         * 能否找到任意两种相邻的价格差绝对值都大于 mid的糖果
         */
        private boolean greedy(int[] price, int k, int target) {
            int prev = Integer.MIN_VALUE / 2;
            int cnt = 0;
            //从小到大遍历price数组
            for (int p : price) {
                if (p - prev >= target) {
                    cnt++;
                    prev = p;
                }
            }
            return cnt >= k;
        }
    }
}
