package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 904. 水果成篮
 * @date 2022/10/17 09:32
 */
public class TotalFruit {
    /**
     * 思路：滑动窗口
     */
    class Solution {
        public int totalFruit(int[] fruits) {
            int n = fruits.length, res = 0, left = 0, type = 0;
            int[] cnt = new int[n];
            for (int right = 0; right < n; right++) {
                if (cnt[fruits[right]] == 0) {
                    type++;
                    //大于两种水果，左指针移动
                    while (type > 2) {
                        cnt[fruits[left]]--;
                        if (cnt[fruits[left]] == 0) {
                            type--;
                        }
                        left++;
                    }
                }
                cnt[fruits[right]]++;
                res = Math.max(res, right - left + 1);
            }
            return res;
        }
    }
}
