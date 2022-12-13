package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2486. 追加字符以获得子序列
 * @date 2022/12/13 10:21
 */
public class AppendCharacters {
    public static void main(String[] args) {
        AppendCharacters.Solution solution = new AppendCharacters().new Solution();
        int out = solution.appendCharacters("abcde", "a");
        System.out.println(out);
    }

    class Solution {
        public int appendCharacters(String s, String t) {
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.toCharArray()[i] == t.toCharArray()[max]) {
                    max++;
                    if (max == t.length()) {
                        return 0;
                    }
                }
            }
            return t.length() - max;
        }
    }

    class Solution2 {
        public int appendCharacters(String s, String t) {
            int m = s.length(), n = t.length();
            int a = 0, b = 0;
            while (a < m && b < n) {
                char c = t.charAt(b);
                while (a < m && s.charAt(a) != c) {
                    a++;
                }
                if (a < m) {
                    b++;
                    a++;
                }
            }
            return n - b;
        }
    }
}
