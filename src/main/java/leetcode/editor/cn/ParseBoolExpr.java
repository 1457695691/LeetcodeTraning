package leetcode.editor.cn;

/**
 * 1106. 解析布尔表达式
 *
 * @author Ayuan
 */
public class ParseBoolExpr {
    /**
     * 两个栈模拟
     */
    class Solution {
        public boolean parseBoolExpr(String expression) {
            if ("t".equals(expression)) {
                return true;
            }
            if ("f".equals(expression)) {
                return false;
            }
            char start = expression.charAt(0);
            int n = expression.length();
            if (start == '!') {
                return !parseBoolExpr(expression.substring(2, n - 1));
            }
            expression = expression.substring(2, n - 1) + ",";
            for (int i = 0, j = 0, count = 0; i < n - 2; i++) {
                char ch = expression.charAt(i);
                if (ch == '(') {
                    count++;
                } else if (ch == ')') {
                    count--;
                } else if (ch == ',' && count == 0) {
                    boolean b = parseBoolExpr(expression.substring(j, i));
                    if (start == '|' && b) {
                        return true;
                    }
                    if (start == '&' && !b) {
                        return false;
                    }
                    j = i + 1;
                }
            }
            return start == '&';
        }
    }
}
