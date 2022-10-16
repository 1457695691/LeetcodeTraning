package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 剑指 Offer 56 - I. 数组中数字出现的次数
 * @date 2022/9/26 11:16
 */
public class SingleNumbers {
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int z = 0;
            for (int num : nums) {
                z ^= num;
            }
            //辅助变量m，保存z中哪一位是1，找最低位的就行
            int m = 1;
            //每次m左移一位和z与，直到结果不为0
            while ((z & m) == 0) {
                m <<= 1;
            }
            int x = 0, y = 0;
            //分组
            for (int num : nums) {
                if ((num & m) == 0) {
                    x ^= num;
                } else {
                    y ^= num;
                }
            }
            return new int[]{x, y};
        }
    }
}
