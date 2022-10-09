package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 124. 二叉树中的最大路径和
 * @date 2022/9/23 16:22
 */
public class MaxPathSum {

    /**
     * 1.站在根节点上思考，左节点路径和， 右节点路径和
     * 2.三种情况： 1。自己的根节点就是路径， 2。左节点加上左路径和 3。右节点加上右路径和
     */
    class Solution {
        int max = 0;

        public int maxPathSum(TreeNode root) {
            maxPathSum(root);
            return max;
        }

        private int getMax(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return node.val;
        }
    }
}
