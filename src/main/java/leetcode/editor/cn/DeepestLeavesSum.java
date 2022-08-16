package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 *
 * @author Ayuan
 */
public class DeepestLeavesSum {

    public static void main(String[] args) {
        DeepestLeavesSum.Solution solution = new DeepestLeavesSum().new Solution();
    }

    /**
     * 深度dfs
     */
    class Solution {
        int max = 0;
        int sum = 0;

        public int deepestLeavesSum(TreeNode root) {
            dfs(root, 0);
            return sum;
        }

        public void dfs(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            if (level > max) {
                max = level;
                sum = node.val;
            } else if (level == max) {
                sum += node.val;
            }
            dfs(node.left, level + 1);
            dfs(node.right, level + 1);
        }

    }

    /**
     * 广度bfs
     */
    class Solution2 {
        public int deepestLeavesSum(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int sum = 0;
            while (!queue.isEmpty()) {
                int levelCount = queue.size();
                sum = 0;
                while (levelCount > 0) {
                    TreeNode poll = queue.poll();
                    sum += poll.val;
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                    levelCount--;
                }
            }
            return sum;
        }
    }
}