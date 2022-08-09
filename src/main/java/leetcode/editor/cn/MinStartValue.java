package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1413. 逐步求和得到正数的最小值
 * @date 2022/8/9 09:17
 */
public class MinStartValue {

    public static void main(String[] args) {
        MinStartValue.Solution solution = new MinStartValue().new Solution();
        int[] nums = {-3, 2, -3, 4, 2};
        int out = solution.minStartValue(nums);
        System.out.println(out);
    }


    class Solution {
        public int minStartValue(int[] nums) {
            int res = 0;
            int sum = 0;
            for (int num : nums) {
                sum += num;
                res = Math.min(res, sum);
            }
            return Math.abs(res) + 1;
        }
    }
}
