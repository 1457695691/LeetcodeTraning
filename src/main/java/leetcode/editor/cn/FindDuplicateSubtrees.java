package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 *
 * @author Ayuan
 */
public class FindDuplicateSubtrees {


    class Solution {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new LinkedList<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            search(root);
            return res;
        }

        //序列化
        private String search(TreeNode root) {
            if (root == null) {
                return "";
            }
            //先序遍历和后续遍历都行
            String s = +root.val + "@"
                    + search(root.left) + "@"
                    + search(root.right);
            if (map.getOrDefault(s, 0) == 1) {
                res.add(root);
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
            return s;
        }
    }

}
