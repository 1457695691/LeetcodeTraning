package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 面试题 01.09. 字符串轮转
 * @date 2022/9/29 09:30
 */
public class IsFlipedString {
    class Solution {
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()){
                return false;
            }
            String s = s1+s2;
            return s.contains(s1);
        }
    }
}
