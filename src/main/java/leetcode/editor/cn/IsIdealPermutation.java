package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 775. 全局倒置与局部倒置
 * @date 2022/11/16 09:34
 */
public class IsIdealPermutation {
    /**
     * 全局倒置: 右边的大于左边的，可以不相邻
     * 局部倒置: 右边的大于左边的，必须相邻
     * 所以局部倒置一定是全局倒置，根据题意直接找非相邻数字是否满足递增就行了
     */
    class Solution {
        public boolean isIdealPermutation(int[] nums) {
            int max = nums[0];
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] < max) {
                    return false;
                }
                max=Math.max(max,nums[i-1]);
            }
            return true;
        }
    }
}
