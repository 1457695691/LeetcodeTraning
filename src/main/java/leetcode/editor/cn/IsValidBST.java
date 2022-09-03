package leetcode.editor.cn;

/**
 * @author Ayuan
 */
public class IsValidBST {
    /**
     * 思路:中序遍历为升序
     */
    class Solution {
        long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            //左子树
            if (!isValidBST(root.left)) {
                return false;
            }
            //如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，
            //返回 false；否则继续遍历。
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            return isValidBST(root.right);
        }
    }
}
