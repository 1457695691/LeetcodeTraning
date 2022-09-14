package leetcode.editor.cn;

/**
 * 669. 修剪二叉搜索树
 *
 * @author Ayuan
 */
public class TrimBST {
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            return root == null ? null : root.val < low ?
                    trimBST(root.right, low, high) : root.val > high
                    ? trimBST(root.left, low, high) : new TreeNode(root.val, trimBST(root.left, low, high), trimBST(root.right, low, high));
        }
    }
}
