package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 623. 在二叉树中增加一行
 * @date 2022/8/5 09:21
 */
public class AddOneRow {
    public static void main(String[] args) {
        AddOneRow.Solution solution = new AddOneRow().new Solution();
        int val = 1, depth = 2;
    }


    class Solution {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            TreeNode ans = new TreeNode(-1, root, null);
            addLayer(0, depth, val, ans);
            return ans.left;
        }

        //d表示当前层
        //depth - 1是原树的叶子层, 那么其原左子树和原右子树就都是空树, 新添加两个值为val的节点作为新的叶子即可
        private void addLayer(int d, int depth, int val, TreeNode root) {
            if (null == root) {
                return;
            }
            if (d == depth - 1) {
                TreeNode l = root.left;
                TreeNode r = root.right;
                root.left = new TreeNode(val, l, null);
                root.right = new TreeNode(val, null, r);
                return;
            }
            addLayer(d + 1, depth, val, root.left);
            addLayer(d + 1, depth, val, root.right);
        }
    }
}
