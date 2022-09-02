package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 687. 最长同值路径
 * @date 2022/9/2 09:43
 */
public class LongestUnivaluePath {
    public static void main(String[] args) {
        LongestUnivaluePath.Solution solution = new LongestUnivaluePath().new Solution();
    }


    class Solution {
        private int max = 0;

        public int longestUnivaluePath(TreeNode root) {
            if (root == null) {
                return max;
            }
            dfs(root, root.val);
            return max;
        }

        public int dfs(TreeNode node, int childrenVal) {
            if (node == null) {
                return 0;
            }
            int l = dfs(node.left, node.val);
            int r = dfs(node.right, node.val);
            //路径长度=左孩子节点数+右孩子节点数+1
            max = Math.max(l + r, max);
            //值相同了才接着遍历
            if (node.val == childrenVal) {
                return Math.max(l, r) + 1;
            }
            return 0;
        }
    }
}
