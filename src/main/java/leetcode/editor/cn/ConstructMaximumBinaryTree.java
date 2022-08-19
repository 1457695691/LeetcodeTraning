package leetcode.editor.cn;

/**
 * 654. 最大二叉树
 *
 * @author Ayuan
 */
public class ConstructMaximumBinaryTree {


    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return dfs(nums, 0, nums.length - 1);
        }

        private TreeNode dfs(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            int idx = right;
            for (int i = left; i < right; ++i) {
                if (nums[idx] < nums[i]) {
                    idx = i;
                }
            }
            return new TreeNode(nums[idx], dfs(nums, left, idx - 1), dfs(nums, idx + 1, right));
        }

    }
}
