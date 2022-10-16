package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: LCP 67. 装饰树
 * @date 2022/10/9 16:48
 */
public class ExpandBinaryTree {
    class Solution {
        public TreeNode expandBinaryTree(TreeNode root) {
            if (root.left != null) {
                root.left = new TreeNode(-1, expandBinaryTree(root.left), null);
            }
            if (root.right != null) {
                root.right = new TreeNode(-1, null, expandBinaryTree(root.right));
            }
            return root;
        }
    }
}
