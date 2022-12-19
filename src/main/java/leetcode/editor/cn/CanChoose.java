package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1764. 通过连接另一个数组的子数组得到一个数组
 * @date 2022/12/17 10:29
 */
public class CanChoose {
    public static void main(String[] args) {
        CanChoose.Solution solution = new CanChoose().new Solution();
    }


    /**
     * 双指针
     */
    class Solution {
        public boolean canChoose(int[][] groups, int[] nums) {
            int n = nums.length, m = groups.length;
            int res = 0;
            for (int i = 0, j = 0; i < n && j < m; ) {
                if (check(groups[j], nums, i)) {
                    i += groups[j++].length;
                    res++;
                } else {
                    i++;
                }
            }
            return res == m;
        }

        boolean check(int[] group, int[] nums, int i) {
            int j = 0;
            for (; j < group.length && i < nums.length; j++, i++) {
                if (group[j] != nums[i]) return false;
            }
            return j == group.length;
        }
    }

}
