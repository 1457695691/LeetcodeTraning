package leetcode.editor.cn;

/**
 * 50. Pow(x, n)
 *
 * @author Ayuan
 */
public class MyPow {
    class Solution {
        public double myPow(double x, int n) {
            /**
             * 快速幂等解法
             */
            if (x == 0.0f) {
                return 0.0d;
            }
            long b = n;
            double res = 1.0d;
            if (b < 0) {
                x = 1 / x;
                b = -b;
            }
            while (b > 0) {
                if ((b & 1) == 1) {
                    res *= x;
                }
                x *= x;
                b >>= 1;
            }
            return res;
        }
    }
}
