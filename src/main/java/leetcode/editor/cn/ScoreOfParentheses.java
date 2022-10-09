package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 856. 括号的分数
 * @date 2022/10/9 09:27
 */
public class ScoreOfParentheses {
    public static void main(String[] args) {
        ScoreOfParentheses.Solution solution = new ScoreOfParentheses().new Solution();
        int out = solution.scoreOfParentheses("(()(()))");
        System.out.println(out);
    }

    /**
     * 思路：栈模拟
     */
    class Solution {
        public int scoreOfParentheses(String s) {
            //当前的括号所在层数
            int res = 0, size = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ('(' == c) {
                    size++;
                } else {
                    //当遇到右括号时，看前面一个位置是否是左括号
                    if (s.charAt(i - 1) == '(') {
                        //是的话就累计结果，不是的话就只是层数减1。
                        res += 1 << size;
                    }
                    size--;
                }
            }
            return res;
        }
    }
}
