package leetcode.editor.cn;

/**
 * @author Ayuan
 */
public class GcdOfStrings {
    public static void main(String[] args) {
        GcdOfStrings.Solution solution = new GcdOfStrings().new Solution();
        String s = solution.gcdOfStrings("ABCABCABC", "ABCABC");
        System.out.println(s);
    }

    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if (!(str1 + str2).equals(str2 + str1)) {
                return "";
            }
            if (str1.length() < str2.length()) {
                String tmp = str1;
                str1 = str2;
                str2 = tmp;
            }
            if (str1.equals(str2)) {
                return str2;
            }
            return gcdOfStrings(str2, str1.substring(0, str1.length() - str2.length()));
        }
    }
}
