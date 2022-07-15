package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 001. 整数除法
 * @date 2022/7/15 14:02
 */
public class Divide {

    private static final int BOUND = Integer.MIN_VALUE >> 1;

    public static void main(String[] args) {
        Divide.Solution solution = new Divide().new Solution();
        int a = 15, b = 2;
        int divide = solution.divide(a, b);
        System.out.println(divide);
    }

    class Solution {
        public int divide(int a, int b) {
            //排除特殊情况
            if (b == 1) {
                return a;
            }
            if (b == -1) {
                return Integer.MIN_VALUE == a ? Integer.MAX_VALUE : -a;
            }
            if (a == 0) {
                return 0;
            }
            //确定符号位 异或操作
            boolean positive = (a ^ b) >= 0;
            //为避免溢出, 转换为负数进行计算
            a = a < 0 ? a : -a;
            b = b < 0 ? b : -b;
            //快速相减
            int quotient = 0;
            while (a <= b) {
                int base = 1;
                int divisor = b;
                while (a - divisor <= divisor) {
                    divisor <<= 1;
                    base <<= 1;
                }
                quotient += base;
                a -= divisor;
            }
            return positive ? quotient : -quotient;
        }
    }
}
