package leetcode.editor.cn;

/**
 * 1678. 设计 Goal 解析器
 *
 * @author Ayuan
 */
public class Interpret {

    class Solution {
        public String interpret(String command) {
            return command.replace("()", "o").replace("(al)", "al");
        }
    }
}
