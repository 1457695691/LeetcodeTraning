package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: LCP 66. 最小展台数量
 * @date 2022/10/9 16:34
 */
public class MinNumBooths {
    class Solution {
        public int minNumBooths(String[] demand) {
            int[] count = new int[26];
            for (String str : demand) {
                int[] map = new int[26];
                for (int i = 0; i < str.length(); i++) {
                    map[str.charAt(i) - 'a']++;
                }
                for (int i = 0; i < 26; i++) {
                    count[i] = Math.max(count[i], map[i]);
                }
            }
            int res = 0;
            for (int i = 0; i < 26; i++) {
                res += count[i];
            }
            return res;
        }
    }
}
