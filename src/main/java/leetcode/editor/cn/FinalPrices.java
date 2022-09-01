package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1475. 商品折扣后的最终价格
 * @date 2022/9/1 11:21
 */
public class FinalPrices {

    /**
     * 利用数组实现单调堆
     * 单调栈解法
     */
    public static void main(String[] args) {
        FinalPrices.Solution solution = new FinalPrices().new Solution();
        int[] prices = {8, 4, 6, 2, 3};
        int[] out = solution.finalPrices(prices);
        System.out.println(Arrays.toString(out).toString());
    }

    class Solution {
        public int[] finalPrices(int[] prices) {
            int index = -1;
            int[] stack = new int[prices.length];
            //倒序遍历，
            for (int i = prices.length - 1; i >= 0; --i) {
                while (index != -1 && stack[index] > prices[i]) {
                    index--;
                }
                int result = index == -1 ? prices[i] : prices[i] - stack[index];
                stack[++index] = prices[i];
                prices[i] = result;
            }
            return prices;
        }
    }
}
