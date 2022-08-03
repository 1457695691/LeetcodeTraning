package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 019. 最多删除一个字符得到回文
 * @date 2022/8/3 10:22
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome.Solution solution = new ValidPalindrome().new Solution();
        boolean out = solution.validPalindrome("aba");
        System.out.println(out);
    }

    class Solution {
        public boolean validPalindrome(String s) {
            return this.search(s, 0, s.length() - 1, false);
        }

        private boolean search(String s, int l, int r, boolean flag) {
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    if (flag) {
                        // flag 表示是否删除过字符串，初始状态为 false
                        return false;
                    }
                    // 递归调用，并把 flag 状态置为 true 表示已经删除过字符
                    // l + 1 表示删除 l 指针位置的字符  r - 1 表示删除 r 指针位置的字符
                    return search(s, l + 1, r, true) || search(s, l, r - 1, true);
                }
                l++;
                r--;
            }
            return true;
        }
    }
}
