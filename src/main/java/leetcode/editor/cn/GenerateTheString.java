package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1374. 生成每种字符都是奇数个的字符串
 * @date 2022/8/1 09:12
 */
public class GenerateTheString {
    public static void main(String[] args) {
        GenerateTheString.Solution solution = new GenerateTheString().new Solution();
        String out = solution.generateTheString(4);
        System.out.println(out);
    }


    class Solution {
        public String generateTheString(int n) {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n - 1; i++) {
                ans.append("a");
            }
            ans.append(n % 2 == 0 ? "b" : "a");
            return ans.toString();
        }
    }
}
