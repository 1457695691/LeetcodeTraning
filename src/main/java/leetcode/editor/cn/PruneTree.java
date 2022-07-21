package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 814. 二叉树剪枝
 * @date 2022/7/21 14:02
 */
public class PruneTree {
    public static void main(String[] args) {
        PruneTree.Solution solution = new PruneTree().new Solution();
    }

    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            if (null == root) {
                return null;
            }
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            if (root.left != null || root.right != null) {
                return root;
            }
            return root.val == 0 ? null : root;
        }
    }
}

