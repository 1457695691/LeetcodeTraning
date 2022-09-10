package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 1711. 大餐计数
 * @date 2022/9/6 16:59
 */
public class CountPairs {
    public static void main(String[] args) {
        Solution solution = new CountPairs().new Solution();
    }

    /**
     * hashmap+容斥原理
     */
    class Solution {
        int mod = (int) 1e9 + 7;
        int max = 1 << 22;
        public int countPairs(int[] deliciousness) {
            /**
             * 思路：
             * 1.hashmap统计出现过的数
             * 2.每个num反查 t=i-x存在不，存在+1
             * 匹配到了+1就行了
             */
            int res = 0;
            Map<Integer, Integer> map = new HashMap<>(10);
            //预先初始化数据 k:num v:出现的次数
            for (int num : deliciousness) {
                for (int i = 1; i < max; i <<= 1) {
                    int t = i - num;
                    if (map.containsKey(t)) {
                        res += map.get(t);
                        if (res >= mod) {
                            res -= mod;
                        }
                    }
                }
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            return res;
        }
    }
}
