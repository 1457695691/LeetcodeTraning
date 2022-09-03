package leetcode.editor.cn;

/**
 * 191. 位1的个数
 *
 * @author Ayuan
 */
public class HammingWeight {

    /**
     * 位运算常见
     * x & 1 === 0 //判断奇偶
     * x & (x - 1) //清除最右边的1
     * x & -x //得到最右边的1
     */
    public class Solution {
        //基本思路：直接循环二进制中的每一位，判断是否为1，统计1的个数
        public int hammingWeight(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                //让1不断左移 判断该位是否为1
                if ((n & (1 << i)) != 0) {
                    res++;
                }
            }
            return res;
        }
    }

    public class Solution2 {
        //优化:去掉二进制最右边的1
        public int hammingWeight(int n) {
            int res = 0;
            while (n != 0) {
                //不断消掉最右边的1
                n &= n - 1;
                res++;
            }
            return res;
        }
    }


    /**
     * lowbit解法
     */
    public class Solution3 {
        public int hammingWeight(int n) {
            int ans = 0;
            for (int i = n; i != 0; i -= lowbit(i)) {
                ans++;
            }
            return ans;
        }

        int lowbit(int x) {
            return x & -x;
        }
    }

    /**
     * 分组统计
     */
    public class Solution4 {
        public int hammingWeight(int n) {
            n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
            n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
            n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
            n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
            n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
            return n;
        }
    }
}
