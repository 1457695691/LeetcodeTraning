package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 *
 * @author Ayuan
 */
public class SpecialArray {
    public static void main(String[] args) {
        SpecialArray.Solution solution = new SpecialArray().new Solution();
        int[] nums = {3, 5};
        int out = solution.specialArray(nums);
        System.out.println(out);
    }

    class Solution {
        public int specialArray(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            if (nums[0] >= n) {
                return n;
            }
            for (int i = 1; i < n; i++) {
                if (nums[n - i] >= i && nums[n - i - 1] < i) {
                    return i;
                }
            }
            return -1;
        }
    }
}
