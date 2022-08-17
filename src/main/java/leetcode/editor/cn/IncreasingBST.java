package leetcode.editor.cn;

/**
 * 剑指 Offer II 052. 展平二叉搜索树
 *
 * @author Ayuan
 */
public class IncreasingBST {
    public static void main(String[] args) {
        IncreasingBST.Solution solution = new IncreasingBST().new Solution();

    }

    class Solution {
        TreeNode head = null;

        public TreeNode increasingBST(TreeNode root) {
            dfs(root);
            return head;
        }

        public void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.right);
            node.right = head;
            head = node;
            dfs(node.left);
            node.left = null;
        }
    }
}
