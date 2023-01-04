package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1802. 有界数组中指定下标处的最大值
 * @date 2023/1/4 09:43
 */
public class MaxValue {

    class Solution {
        public int maxValue(int n, int index, int maxSum) {
            int rCount = n - 1 - index; // 山峰左右两侧的元素数量
            int l = 1, r = maxSum; // 二分查找的左右边界
            while (l <= r) {
                int m = (l + r) / 2;
                long sum = m + helper(m, index) + helper(m, rCount);
                if (sum > maxSum) r = --m;
                else l = ++m;
            }
            return l - 1; // 此时，l 代表数组和恰好大于 maxSum 时的数组和。
        }
    }

    /*求山峰一侧的元素的和，max 为山峰大小，k 为某一侧的元素数量*/
    private long helper(int max, int k) {
        if (max > k) return (long) k * (2L * max - 1 - k) / 2;
        else return (long) (max - 3) * max / 2 + k + 1;
    }
}
