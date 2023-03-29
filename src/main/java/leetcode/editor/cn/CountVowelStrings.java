package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1641. 统计字典序元音字符串的数目
 * @date 2023/3/29 14:56
 */
public class CountVowelStrings {
    class Solution {
        public int countVowelStrings(int n) {
            int a = 1, e = 1, i = 1, o = 1, u = 1;
            while (--n > 1) {
                e = a + e;
                i = e + i;
                o = i + o;
                u = o + u;
            }
            return a + e + i + o + u;
        }
    }
}
