package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 面试题 17.19. 消失的两个数字
 * @date 2022/9/26 10:52
 */
public class MissingTwo {

    public static void main(String[] args) {
        MissingTwo.Solution solution = new MissingTwo().new Solution();
        int[] nums = {2};
        int[] out = solution.missingTwo(nums);
        System.out.println(Arrays.toString(out));
    }

    class Solution {
        public int[] missingTwo(int[] nums) {
            // 数据总长度
            int totalLength = nums.length + 2;
            // 数据总和
            int totalSum = ((totalLength + 1) * totalLength) >> 1;
            // totalSum = 消失的两个数的总和
            for (int num : nums) {
                totalSum -= num;
            }
            // 消失的两个数的中位数，肯定一个大于missHalf , 一个小于missHalf
            int missingHalf = totalSum >> 1;
            // 中位数之前一半的数据总和
            int missHalfSum = ((missingHalf + 1) * missingHalf) >> 1;
            // 消失的小的那个数 = missHalfSum减去剩下元素
            for (int num : nums) {
                if (num <= missingHalf) {
                    missHalfSum -= num;
                }
            }
            //消失的大的那个数 = 两数之和 - 小数
            return new int[]{missHalfSum, totalSum - missHalfSum};
        }
    }
}