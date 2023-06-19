package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1262. 可被三整除的最大和
 * @date 2023/6/19 10:15
 */
public class MaxSumDivThree {
    class Solution {
        public int maxSumDivThree(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum % 3 == 0) {
                return sum;
            }
            Arrays.sort(nums);
            int temp = 0, ans = 0;
            for (int i = 0; i < nums.length; i++) {
                temp = sum;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] % 3 == 0) {
                        continue;
                    }
                    temp -= nums[j];
                    if (temp % 3 == 0) {
                        ans = Math.max(ans, temp);
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
