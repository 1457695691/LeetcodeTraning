package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1080. 根到叶路径上的不足节点
 * @date 2023/5/22 10:33
 */
public class SufficientSubset {
    class Solution {
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            limit -= root.val;
            if (root.left == root.right) {
                // 如果 limit > 0 说明从根到叶子的路径和小于 limit，删除叶子，否则不删除
                return limit > 0 ? null : root;
            }
            if (root.left != null) {
                root.left = sufficientSubset(root.left, limit);
            }
            if (root.right != null) {
                root.right = sufficientSubset(root.right, limit);
            }
            return root.left == null && root.right == null ? null : root;
        }
    }
}
