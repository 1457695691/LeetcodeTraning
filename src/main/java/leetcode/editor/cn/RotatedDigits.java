package leetcode.editor.cn;

/**
 * @author Ayuan
 */
public class RotatedDigits {

    public static void main(String[] args) {
        RotatedDigits.Solution solution = new RotatedDigits().new Solution();
        int out = solution.rotatedDigits(10);
        System.out.println(out);
    }

    class Solution {
        public int rotatedDigits(int n) {
            int count = 0;
            for (int i = 2; i <= n; i++) {
                String s = String.valueOf(i);
                s = s.replaceAll("[+0,+1,+8]", "");
                if (!"".equals(s)) {
                    s = s.replaceAll("[+2.+5,+6,+9]+", "");
                    if ("".equals(s)) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}