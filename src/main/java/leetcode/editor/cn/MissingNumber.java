package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 268. 丢失的数字
 *
 * @author Ayuan
 */
public class MissingNumber {

    /**
     * 排序后查找：O(nlogn)
     */
    class Solution1 {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return nums.length;
        }
    }

    /**
     * 思路:位运算 异或 O(n)
     * 找缺失数、找出现一次数都等都属于异或题
     */
    class Solution2 {
        public int missingNumber(int[] nums) {
            int ans = nums.length;
            for (int i = 0; i < nums.length; i++) {
                ans ^= i ^ nums[i];
            }
            return ans;
        }
    }

    /**
     * 数学法 首项加尾项乘以项数乘以二 O(n)
     */
    class Solution3 {
        public int missingNumber(int[] nums) {
            int ans = nums.length * (nums.length + 1) / 2;
            for (int num : nums) {
                ans -= num;
            }
            return ans;
        }
    }

    /**
     * hashset法：O(n)
     */
    class Solution4 {
        public int missingNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            for (int i = 0; i < nums.length; i++) {
                if (!set.contains(i)) {
                    return i;
                }
            }
            return nums.length;
        }
    }

}
