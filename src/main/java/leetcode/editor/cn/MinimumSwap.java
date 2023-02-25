package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1247. 交换字符使得字符串相同
 * @date 2023/2/25 09:47
 */
public class MinimumSwap {

    public static void main(String[] args) {
        String s1 = "xyxyyx"; //101001
        String s2 = "yxyxxy"; //010110
        MinimumSwap.Solution solution = new MinimumSwap().new Solution();
        int out = solution.minimumSwap(s1, s2);
        System.out.println(out);
    }

    class Solution {
        public int minimumSwap(String s1, String s2) {
            int[] cnt = new int[2];
            for (int i = 0; i < s1.length(); ++i) {
                if (s1.toCharArray()[i] != s2.toCharArray()[i]) {
                    ++cnt[s1.toCharArray()[i] % 2];
                }
            }
            int d = cnt[0] + cnt[1];
            return d % 2 != 0 ? -1 : d / 2 + cnt[0] % 2;
        }
    }

    class Solution2 {
        public int minimumSwap(String s1, String s2) {
            int xy = 0, yx = 0;
            for (int i = 0; i < s1.length(); ++i) {
                char a = s1.charAt(i), b = s2.charAt(i);
                if (a < b) {
                    ++xy;
                }
                if (a > b) {
                    ++yx;
                }
            }
            if ((xy + yx) % 2 == 1) {
                return -1;
            }
            return xy / 2 + yx / 2 + xy % 2 + yx % 2;
        }
    }

}
