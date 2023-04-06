package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/4/6 10:00
 */
public class BaseNeg2 {
    class Solution {
        public String baseNeg2(int n) {
            if (n == 0) return "0";
            StringBuilder sb = new StringBuilder();
            while (n != 0) {
                sb.insert(0, Math.abs(n % -2));
                n = n % -2 == 0 ? n / -2 : (n - 1) / -2;
            }
            return sb.toString();
        }
    }
}
