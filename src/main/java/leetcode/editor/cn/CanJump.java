package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 55. 跳跃游戏
 * @date 2022/9/23 14:09
 */
public class CanJump {

    /**
     * 1.如果数组里面的数全部大于等于0，直接返回true
     * 2.如果有0，看0之前的位置够不够跨过去
     */
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length == 0) {
                return true;
            }
            int cur = nums[0], i = 1;
            for (; cur != 0 && i < nums.length; i++) {
                cur--;
                if (cur < nums[i]) {
                    cur = nums[i];
                }
            }
            return i == nums.length;
        }
    }
}
