package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1026. 节点与其祖先之间的最大差值
 * @date 2023/4/18 09:39
 */
public class MaxAncestorDiff {

    class Solution {
        private int res = 0;

        public int maxAncestorDiff(TreeNode root) {
            if (root == null) {
                return res;
            }
            dfs(root, root.val, root.val);
            return res;
        }

        private void dfs(TreeNode node, int max, int min) {
            if (node == null) {
                return;
            }
            min = Math.min(min, node.val);
            max = Math.max(max, node.val);
            res = Math.max(res, max - min);
            dfs(node.left, max, min);
            dfs(node.right, max, min);
        }
    }
}
