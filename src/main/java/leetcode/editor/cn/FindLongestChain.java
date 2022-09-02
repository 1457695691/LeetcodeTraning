package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 646. 最长数对链
 *
 * @author Ayuan
 */
public class FindLongestChain {
    /**
     * 贪心算法:不断选取局部最优解,从而达到全局最优解
     * 条件:1.求解最值问题2.子问题的每一步选择都对后续的选择没有影响
     * 例子:打游戏爆了一地装备，背包有一定的负重，你要选择价值最高的装备捡.
     * 如果你在集某些套装，那么你就会挑选套装的装备捡，这就是套装优先前提下的最优组合，不可能说我又要价值最高又符合我的套装。
     */
    public static void main(String[] args) {
        FindLongestChain.Solution solution = new FindLongestChain().new Solution();
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        int out = solution.findLongestChain(pairs);
        System.out.println(out);
    }

    /**
     * 思路:第二个数字挑最小的拿
     */
    class Solution {
        public int findLongestChain(int[][] pairs) {
            //1.先按照第二个数字排序
            //2.循环判断第一个数字是否大于前一个数对的第二个数字
            Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
            int res = 0, cur = -1 << 30;
            for (int[] p : pairs) {
                if (cur < p[0]) {
                    cur = p[1];
                    res++;
                }
            }
            return res;
        }
    }
}
