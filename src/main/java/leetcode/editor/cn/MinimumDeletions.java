package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1653. 使字符串平衡的最少删除次数
 * @date 2022/9/6 17:57
 */
public class MinimumDeletions {
    public static void main(String[] args) {
        Solution solution = new MinimumDeletions().new Solution();
        int out = solution.minimumDeletions("aababbab");
        System.out.println(out);
    }


    class Solution {
        public int minimumDeletions(String s) {
            return 1;
        }
    }
}
