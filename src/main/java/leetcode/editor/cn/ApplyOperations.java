package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2460. 对数组执行操作
 * @date 2023/6/5 09:52
 */
public class ApplyOperations {
    class Solution {
        public int[] applyOperations(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    nums[i] *= 2;
                    nums[i + 1] = 0;
                }
            }
            int i = 0, j = 0;
            while (i < n) {
                if (nums[i] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }
                i++;
            }
            return nums;
        }

    }
}
