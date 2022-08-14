package leetcode.editor.cn;

/**
 * @author Ayuan
 */
public class MaxScore {
    public static void main(String[] args) {
        MaxScore.Solution solution = new MaxScore().new Solution();
        int out = solution.maxScore("011101");
        System.out.println(out);
    }


    class Solution {
        public int maxScore(String s) {
            int max = 0;
            int[] digits = new int[2];
            for (int i = 0; i < s.length(); i++) {
                digits[s.charAt(i) - '0']++;
            }
            int score1 = 0, score2 = digits[1];
            for (int i = 0; i < s.length() - 1; i++) {
                digits[s.charAt(i) - '0']--;
                score1 += s.charAt(i) == '0' ? 1 : 0;
                score2 -= s.charAt(i) == '1' ? 1 : 0;
                int curMaxScore = score1 + score2;
                if (curMaxScore > max) {
                    max = curMaxScore;
                }
            }
            return max;
        }
    }
}
