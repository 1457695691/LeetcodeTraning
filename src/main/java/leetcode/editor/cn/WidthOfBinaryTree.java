package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * 662. 二叉树最大宽度
 *
 * @author Ayuan
 */
public class WidthOfBinaryTree {

    /**
     * 左孩子编号是父节点编号的两倍，即 left = 2×root
     * 右孩子编号是父节点编号的两倍加一，即 right =2×root+1
     */
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            int max = 0;
            LinkedList<Pair<TreeNode, Integer>> list = new LinkedList<>();
            list.addLast(new Pair<>(root, 1));
            while (!list.isEmpty()) {
                int size = list.size();
                int low = list.getFirst().getValue(), high = list.getLast().getValue();
                max = Math.max(max, high - low + 1);
                for (int i = 0; i < size; i++) {
                    Pair<TreeNode, Integer> pair = list.removeFirst();
                    TreeNode key = pair.getKey();
                    if (key.left != null) {
                        list.addLast(new Pair<>(key.left, pair.getValue() * 2));
                    }
                    if (key.right != null) {
                        list.addLast(new Pair<>(key.right, pair.getValue() * 2 + 1));
                    }
                }
            }
            return max;
        }
    }
}
