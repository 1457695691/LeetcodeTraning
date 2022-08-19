package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ayuan
 */
public class LongestStrChain {

    public static void main(String[] args) {
        LongestStrChain.Solution solution = new LongestStrChain().new Solution();
        String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        int out = solution.longestStrChain(words);
        System.out.println(out);
//        System.out.println(solution.isAfter("bac", "bcad"));
    }

    class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words, Comparator.comparingInt(String::length));
            int res = 0;
            int[] tmp = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                String a = words[i];
                for (int j = i + 1; j < words.length; j++) {
                    String b = words[j];
                    if (isAfter(a, b)) {
                        tmp[j] = Math.max(tmp[i] + 1, tmp[j]);
                        res = Math.max(tmp[j], res);
                    }
                }
            }
            return res + 1;
        }

        /**
         * a是不是b的前身
         */
        public boolean isAfter(String a, String b) {
            int m = a.length(), n = b.length();
            if ((m + 1) != n) {
                return false;
            }
            int i = 0, j = 0;
            while (i < m && j < n) {
                if (a.charAt(i) == b.charAt(j)) {
                    i++;
                }
                j++;
            }
            return i == m;
        }
    }
}
