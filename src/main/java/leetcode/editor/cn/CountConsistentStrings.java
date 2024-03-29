package leetcode.editor.cn;


/**
 * @author Ayuan
 * @Description: 1684. 统计一致字符串的数目
 * @date 2022/11/8 09:26
 */
public class CountConsistentStrings {

    class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            int[] map = new int[26];
            for (int i = 0; i < allowed.length(); i++) {
                map[allowed.charAt(i) - 'a']++;
            }
            int res = 0;
            for (String w : words) {
                boolean isConsistent = true;
                for (int i = 0; i < w.length(); i++) {
                    if (map[w.charAt(i) - 'a'] == 0) {
                        isConsistent = false;
                        break;
                    }
                }
                if (isConsistent) {
                    res++;
                }
            }
            return res;
        }
    }
}
