package leetcode.editor.cn;

/**
 * 1624. 两个相同字符之间的最长子字符串
 *
 * @author Ayuan
 */
public class MaxLengthBetweenEqualCharacters {

    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            int max = -1;
            for (int i = 0; i < s.length(); i++) {
                int a = s.indexOf(s.charAt(i));
                int b = s.lastIndexOf(s.charAt(i));
                if (b - a > max) {
                    max = b - a;
                }
            }
            return max - 1;
        }
    }
}
