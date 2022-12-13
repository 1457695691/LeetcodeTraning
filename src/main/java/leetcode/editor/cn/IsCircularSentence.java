package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2490. 回环句
 * @date 2022/12/13 14:46
 */
public class IsCircularSentence {
    class Solution {
        public boolean isCircularSentence(String sentence) {
            //首尾不同直接返回
            if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
                return false;
            }
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ' && sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
