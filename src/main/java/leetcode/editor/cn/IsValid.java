package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 20. 有效的括号
 * @date 2023/4/4 09:55
 */
public class IsValid {
    class Solution {
        public boolean isValid(String s) {
            int length = s.length() / 2;
            for (int i = 0; i < length; i++) {
                s = s.replace("()", "").replace("{}", "").replace("[]", "");
            }
            return s.length() == 0;
        }
    }
}
