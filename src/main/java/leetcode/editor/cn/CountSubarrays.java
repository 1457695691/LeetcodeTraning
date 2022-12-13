package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 2488. 统计中位数为 K 的子数组
 * @date 2022/12/13 11:50
 */
public class CountSubarrays {
    public static void main(String[] args) {
        CountSubarrays.Solution solution = new CountSubarrays().new Solution();
        int[] nums = {3, 2, 1, 4, 5};
        int k = 4;
        int out = solution.countSubarrays(nums, k);
        //out = 3
        System.out.println(out);
    }


    /**
     * 前缀和思路
     */
    class Solution {
        public int countSubarrays(int[] nums, int k) {
            int n = nums.length, res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            //find表示是否找到key
            boolean find = false;
            for (int i = 0, s = 0; i < n; ++i) {
                s += Integer.compare(nums[i], k);
                if (find |= nums[i] == k) {
                    // s - s = 0 表示正负数一样多
                    res += map.getOrDefault(s, 0);
                    // s - (s-1) = 1 表示正数比负数多一个
                    res += map.getOrDefault(s - 1, 0);
                } else {
                    map.merge(s, 1, Integer::sum);
                }
            }
            return res;
        }
    }
}
