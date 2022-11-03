package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1668. 最大重复子字符串
 * @date 2022/11/3 10:13
 */
public class MaxRepeating {
    class Solution {
        public int maxRepeating(String sequence, String word) {
            int ans = 0;
            String s = word;
            while (sequence.contains(s)) {
                ans++;
                s += word;
            }
            return ans;
        }
    }
}
