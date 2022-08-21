package leetcode.editor.cn;

/**
 * 75. 颜色分类
 *
 * @author Ayuan
 */
public class SortColors {

    class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return;
            }
            int p = 0, q = n - 1;
            for (int i = 0; i <= q; i++) {
                if (nums[i] == 0) {
                    nums[i] = nums[p];
                    nums[p] = 0;
                    ++p;
                }
                if (nums[i] == 2) {
                    nums[i] = nums[q];
                    nums[q] = 2;
                    --q;
                    if (nums[i] != 1) {
                        --i;
                    }
                }
            }
        }
    }
}
