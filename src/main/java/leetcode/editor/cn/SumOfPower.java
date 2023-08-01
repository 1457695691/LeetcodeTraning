package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 2681. 英雄的力量
 * @date 2023/8/1 14:11
 */
public class SumOfPower {
    class Solution {
        public int sumOfPower(int[] nums) {
            int m = 1000000007;
            long res = 0, a = 0;
            Arrays.sort(nums);
            for (int num : nums) {
                res = (res + ((long) num * num % m) * (a + num)) % m;
                a = a * 2 % m + num;
            }
            return (int) res;
        }
    }
}
