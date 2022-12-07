package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1775. 通过最少操作次数使数组的和相等
 * @date 2022/12/7 09:11
 */
public class MinOperations3 {
    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            int res = 0;
            //1. 排除特殊情况（超过都是6的绝对不可能）
            int n1 = nums1.length, n2 = nums2.length;
            if (n1 * 6 < n2 || n2 * 6 < n1) {
                return -1;
            }
            //2. 计算差值（默认nums1为大数组）
            int target = Arrays.stream(nums1).sum() - Arrays.stream(nums2).sum();
            if (target < 0) {
                return minOperations(nums2, nums1);
            }
            //3. 初始化一个数组当作map
            int[] map = new int[6];
            //4. 每个数可以减少的量
            for (int x : nums1) {
                map[x - 1]++;
            }
            //5. 每个数可以增加的量
            for (int x : nums2) {
                map[6 - x]++;
            }
            //6. 遍历map
            for (int i = 5; i >= 1 && target > 0; i--) {
                //最少需要的个数
                //+(i- 1)为了向上取整
                int cnt = Math.min(map[i], (target + i - 1) / i);
                res += cnt;
                //减去能够减少的最大值，若小于等等于0，代表已经使得两个数组相等
                target -= cnt * i;
            }
            return res;
        }
    }
}
