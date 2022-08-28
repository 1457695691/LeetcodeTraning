package leetcode.editor.cn;

/**
 * 1470. 重新排列数组
 *
 * @author Ayuan
 */
public class Shuffle {
    public static void main(String[] args) {
        Shuffle.Solution solution = new Shuffle().new Solution();
        int[] nums = {2, 5, 1, 3, 4, 7};
        int k = 3;
        solution.shuffle(nums, k);
    }

    /**
     * nums = [2,5,1,3,4,7
     */
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            //每个数10次方
            for (int i = 0; i < nums.length; i++) {
                nums[i] <<= 10;
            }
            //(i & 1) == 0判断奇偶性 如果是偶数
            for (int i = 0; i < nums.length; i++) {
                nums[i] |= (i & 1) == 0 ? nums[i >> 1] >> 10 : nums[(i >> 1) + n] >> 10;
                System.out.println(nums[i]);
            }
            //1023=001111111111
            //2050=100000000010 2048 + 2 10
            //2   =000000000010
            for (int i = 0; i < nums.length; i++) {
                nums[i] &= 1023;
            }
            return nums;
        }
    }
}
