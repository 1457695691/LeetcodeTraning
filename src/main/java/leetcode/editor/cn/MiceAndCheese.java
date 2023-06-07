package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 2611. 老鼠和奶酪
 * @date 2023/6/7 11:26
 */
public class MiceAndCheese {
    /**
     * 贪心：
     */
    class Solution {
        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            int ans = 0;
            int n = reward1.length;
            int[] diffs = new int[n];
            for (int i = 0; i < n; i++) {
                //1.先让🐭2把东西全吃了
                ans += reward2[i];
                //2.挨个吐出来和🐭1吃的取差值
                diffs[i] = reward1[i] - reward2[i];
            }
            Arrays.sort(diffs);
            //3.选top K个再喂给🐭1
            for (int i = 1; i <= k; i++) {
                ans += diffs[n - i];
            }
            return ans;
        }
    }

}
