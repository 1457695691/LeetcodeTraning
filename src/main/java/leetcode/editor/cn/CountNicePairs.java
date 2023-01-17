package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 1814. 统计一个数组中好对子的数目
 * @date 2023/1/17 10:32
 */
public class CountNicePairs {
    class Solution {
        public int countNicePairs(int[] nums) {
            //1.变换公式 => num[i] - rev(num[i]) = num[j] - rev(num[j])
            int count = 0;
            //2.利用哈希表存储num[i] - rev(num[i])的值
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int rev = num - rev(num);
                count = (count + map.getOrDefault(rev, 0)) % 1000000007;
                map.put(rev, map.getOrDefault(rev, 0) + 1);
            }
            return count;
        }

        //通过计算反转数字
        public int rev(int x) {
            int sum = 0;
            while (x > 0) {
                sum = sum * 10 + x % 10;
                x /= 10;
            }
            return sum;
        }
    }
}
