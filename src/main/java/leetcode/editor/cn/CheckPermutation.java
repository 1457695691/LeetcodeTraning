package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 面试题 01.02. 判定是否互为字符重排
 * @date 2022/9/27 09:36
 */
public class CheckPermutation {

    /**
     * 解法1： hash
     */
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int[] table = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                table[s1.charAt(i) - 'a']++;
            }
            for (int j = 0; j < s2.length(); j++) {
                table[s2.charAt(j) - 'a']--;
                if (table[s2.charAt(j) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
    /**
     * 解法2：排序后比较，太nt了不写了
     */
}
