package leetcode.editor.cn;

/**
 * 1545. 找出第 N 个二进制字符串中的第 K 位
 *
 * @author Ayuan
 */
public class FindKthBit {
    public static void main(String[] args) {
        FindKthBit.Solution solution = new FindKthBit().new Solution();
        char out = solution.findKthBit(3, 1);
        System.out.println(out);
    }

    class Solution {
        public char findKthBit(int n, int k) {
            if (n == 1) {
                return '0';
            }
            int mid = 1 << (n - 1);
            if (k < mid) {
                return findKthBit(n - 1, k);
            } else if (k == mid) {
                return '1';
            } else {
                k -= mid;
                k = mid - k;
                return findKthBit(n - 1, k) == '0' ? '1' : '0';
            }
        }
    }
}
