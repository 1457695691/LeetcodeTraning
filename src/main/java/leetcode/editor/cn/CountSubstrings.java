package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 020. 回文子字符串的个数
 * 647. 回文子串
 * @date 2022/8/3 10:47
 */
public class CountSubstrings {
    public static void main(String[] args) {
        CountSubstrings.Solution solution = new CountSubstrings().new Solution();
        int out = solution.countSubstrings("aaaaa");
        System.out.println(out);
    }

    class Solution {
        public int countSubstrings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < s.length(); ++i) {
                count += search(s, i, i);
                //中心两个字符
                count += search(s, i, i + 1);
            }
            return count;
        }
        //从字符串的l位置向左，r位置向右，比较是否为回文并计数
        private int search(String s, int l, int r) {
            int count = 0;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
            return count;
        }
    }
}
