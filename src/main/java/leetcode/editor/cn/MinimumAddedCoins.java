package leetcode.editor.cn;

import java.util.Arrays;

//2952. 需要添加的硬币的最小数量
public class MinimumAddedCoins {
    class Solution {
        public int minimumAddedCoins(int[] coins, int target) {
            Arrays.sort(coins);
            int res = 0, s = 1, i = 0;
            while (s <= target) {
                if (i < coins.length && coins[i] <= s) {
                    s += coins[i++];
                } else {
                    s *= 2;
                    res++;
                }
            }
            return res;
        }
    }
}
