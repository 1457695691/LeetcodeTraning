package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 46. 全排列
 * @date 2022/9/20 15:41
 */
public class Permute {

    /**
     * 回溯算法入门题：模板
     * result = []
     * def backtrack(路径，选择列表)
     * if 满足结束条件
     * result.add(路径)
     * return
     * <p>
     * for 选择 in 选择列表
     * 做选择
     * backtrack(路径，选择列表)
     * 撤销选择
     */
    class Solution {
        //结果
        List<List<Integer>> result = new ArrayList<>();
        //路径
        List<Integer> path = new ArrayList<>();
        //标记已经使用过的数组
        boolean[] used = new boolean[10];

        public List<List<Integer>> permute(int[] nums) {
            backtrack(nums);
            return result;
        }

        public void backtrack(int[] nums) {
            // 判断：结束条件
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                // 如果使用过了，则直接跳过
                if (used[i]) {
                    continue;
                }
                // 先序：首次进入节点，添加到「路径」中
                path.add(nums[i]);
                // 标记使用
                used[i] = true;
                // 递归
                backtrack(nums);
                // 后续：即将离开节点，从「路径」中除去
                path.remove(path.size() - 1);
                // 取消标记
                used[i] = false;
            }
        }
    }
}
