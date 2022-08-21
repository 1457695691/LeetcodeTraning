package leetcode.editor.cn;

/**
 * 459. 重复的子字符串
 *
 * @author Ayuan
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        RepeatedSubstringPattern.Solution solution = new RepeatedSubstringPattern().new Solution();
        boolean out = solution.repeatedSubstringPattern("abab");
        System.out.println(out);
    }

    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            return (s + s).substring(1, s.length() * 2 - 1).contains(s);
        }
    }
}
