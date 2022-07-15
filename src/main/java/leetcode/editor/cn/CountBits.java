package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * @date 2022/7/15 17:07
 */
public class CountBits {
    public static void main(String[] args) {
        CountBits.Solution solution = new CountBits().new Solution();
        int[] outList = solution.countBits(2);
        for (int out : outList) {
            System.out.println(out);
        }
    }


    class Solution {
        public int[] countBits(int n) {
            int[] res = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                //右移一位就是 i/2
                res[i] = res[i >> 1] + (i & 1);
            }
            return res;
        }
    }
}
