package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2337. 移动片段得到字符串
 * @date 2023/8/21 09:34
 */
public class CanChange {

    public static void main(String[] args) {
        Solution solution = new CanChange().new Solution();
        boolean b = solution.canChange("_R", "R_");
        System.out.println(b);
    }

    class Solution {
        public boolean canChange(String start, String target) {
            int n = start.length(), i = 0, j = 0;
            while (i < n || j < n) {
                while (i < n && start.charAt(i) == '_') {
                    i++;
                }
                while (j < n && target.charAt(j) == '_') {
                    j++;
                }
                if (i == n || j == n) {
                    return i == n && j == n;
                }
                char c = start.charAt(i);
                if (c != target.charAt(j) || c == 'L' && i < j || c == 'R' && i > j) {
                    return false;
                }
                i++;
                j++;
            }
            return true;
        }

    }
}
