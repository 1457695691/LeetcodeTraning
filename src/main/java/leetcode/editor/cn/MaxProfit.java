package leetcode.editor.cn;

/**
 * 121. 买卖股票的最佳时机
 *
 * @author Ayuan
 */
public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit.Solution solution = new MaxProfit().new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int out = solution.maxProfit(prices);
        System.out.println(out);
    }

    class Solution {
        public int maxProfit(int[] prices) {
            int min = prices[0], max = 0;
            for (int i = 1; i < prices.length; i++) {
                max = Math.max(max, prices[i] - min);
                min = Math.min(min, prices[i]);
            }
            return max;
        }
    }
}
