package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1785. 构成特定和需要添加的最少元素
 * @date 2022/12/16 09:38
 */
public class MinElements {
    class Solution {
        public int minElements(int[] nums, int limit, int goal) {
            return (int) ((Math.abs(goal - Arrays.stream(nums).mapToLong(i -> (long) i).sum()) + limit - 1) / limit);
        }
    }
}
