package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1144. 递减元素使数组呈锯齿状
 * @date 2023/2/27 09:41
 */
public class MovesToMakeZigzag {

    class Solution {
        public int movesToMakeZigzag(int[] nums) {
            int[] ans = new int[2];
            for (int i = 0; i < 2; ++i) {
                for (int j = i; j < nums.length; j += 2) {
                    int d = 0;
                    if (j > 0) {
                        d = Math.max(d, nums[j] - nums[j - 1] + 1);
                    }
                    if (j < nums.length - 1) {
                        d = Math.max(d, nums[j] - nums[j + 1] + 1);
                    }
                    ans[i] += d;
                }
            }
            return Math.min(ans[0], ans[1]);
        }
    }
}
