package leetcode.editor.cn;

import java.util.TreeSet;

/**
 * @author Ayuan
 * @Description: 面试题 17.09. 第 k 个数
 * @date 2022/9/28 09:34
 */
public class GetKthMagicNumber {

    /**
     * 小根堆
     */
    class Solution {
        public int getKthMagicNumber(int k) {
            long ans = 0;
            TreeSet<Long> set = new TreeSet<>();
            set.add(1L);
            while (k-- > 0) {
                ans = set.pollFirst();
                set.add(ans * 3);
                set.add(ans * 5);
                set.add(ans * 7);
            }
            return (int) (ans);
        }
    }
}
