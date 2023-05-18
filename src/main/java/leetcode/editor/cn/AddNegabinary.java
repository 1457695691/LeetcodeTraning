package leetcode.editor.cn;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * @author Ayuan
 * @Description: 1073. 负二进制数相加
 * @date 2023/5/18 14:03
 */
public class AddNegabinary {
    /**
     * 转成10进制加起来再转成-2进制
     */
    class Solution {
        private BigInteger toNeg2(int[] a) {
            BigInteger n = ZERO;
            for (int i = 0; ++i <= a.length; )
                if (a[a.length - i] == 1) n = n.add(BigInteger.valueOf(2).negate().pow(i - 1));
            return n;
        }

        private List<Integer> fromNeg2(BigInteger n) {
            List<Integer> l = new ArrayList<>();
            while (!n.equals(ZERO)) {
                BigInteger[] qr = n.divideAndRemainder(BigInteger.valueOf(2).negate());
                if (qr[1].equals(ONE.negate())) qr[0] = qr[0].add(qr[1] = ONE);
                n = qr[0];
                l.add(0, qr[1].intValue());
            }
            return l;
        }

        public int[] addNegabinary(int[] x, int[] y) {
            List<Integer> l = fromNeg2(toNeg2(x).add(toNeg2(y)));
            if (l.isEmpty()) return new int[1]; // 特判0
            int[] a = new int[l.size()];
            int i = a.length;
            while (--i >= 0) {
                a[i] = l.get(i);
            }
            return a;
        }
    }
}
