package leetcode.editor.cn;

/**
 * 793. 阶乘函数后 K 个零
 *
 * @author Ayuan
 */
public class PreimageSizeFZF {

    /**
     * 10进制中只有2和5相乘才会得到10，也就是每有一对2和5，就多一个末尾的0
     * 而阶乘又是从1开始乘到x，所以2的个数总是比5多，那么问题转化为求x！中有多少个5作为因子
     * 公式为 k = x/5 + x/5^2 + x/5^3 + ......
     * 根据上面的公式，x/5 + x/5^2 + x/5^3 + ...... = k
     * => x/5 < k <=10^9
     * => x < 5 * 10^9 容易想到在[0, 5*k]内二分求解x
     * 显然，x每+5，阶乘就会至少多乘一个5，末尾就会至少多一个0，所以如果上面的x有解，那就是5个，如果无解就是0
     */
    public static void main(String[] args) {
        PreimageSizeFZF.Solution solution = new PreimageSizeFZF().new Solution();
        int out = solution.preimageSizeFZF(0);
        System.out.println(out);
    }

    class Solution {
        public int preimageSizeFZF(int k) {
            int start = 1;
            while (start < k) {
                start = start * 5 + 1;
            }
            while (start > 1) {
                if (start - 1 == k) {
                    return 0;
                }
                start = (start - 1) / 5;
                k %= start;
            }
            return 5;
        }
    }
}
