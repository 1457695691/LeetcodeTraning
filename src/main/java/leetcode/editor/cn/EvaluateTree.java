package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2331. 计算布尔二叉树的值
 * @date 2023/2/6 10:10
 */
public class EvaluateTree {
    class Solution {
        public boolean evaluateTree(TreeNode root) {
            if (2 == root.val) {
                return evaluateTree(root.left) || evaluateTree(root.right);
            }
            if (3 == root.val) {
                return evaluateTree(root.left) && evaluateTree(root.right);
            }
            return root.val == 1;
        }

    }
}
