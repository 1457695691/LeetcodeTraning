package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 672. 灯泡开关 Ⅱ
 * @date 2022/9/15 09:32
 */
public class FlipLights {
    public static void main(String[] args) {
        FlipLights.Solution solution = new FlipLights().new Solution();
        int out = solution.flipLights(3, 1);
        System.out.println(out);
    }

    class Solution {
        public int flipLights(int n, int presses) {
            if (presses == 0) {
                return 1;
            }
            if (n == 1) {
                return 2;
            }
            if (n == 2) {
                return (presses == 1) ? 3 : 4;
            }
            return (presses > 2) ? 8 : (presses == 1) ? 4 : 7;
        }
    }
}
