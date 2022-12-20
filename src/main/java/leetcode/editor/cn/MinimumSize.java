package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1760. 袋子里最少数目的球
 * @date 2022/12/20 10:00
 */
public class MinimumSize {

    /**
     * 二分查找
     */
    class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            int left = 1, right = Arrays.stream(nums).max().getAsInt();
            while (left < right) {
                int mid = (left + right) / 2;
                if (check(mid, nums, maxOperations)) {
                    right = mid;
                } else {
                    right = mid + 1;
                }
            }
            return right;
        }

        public boolean check(int mid, int[] nums, int maxOperations) {
            for (int x : nums) {
                maxOperations -= (x - 1) / mid;
            }
            return maxOperations >= 0;
        }
    }
}
