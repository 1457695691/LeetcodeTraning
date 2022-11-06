package leetcode.editor.cn;

/**
 * 1652. 拆炸弹
 *
 * @author Ayuan
 */
public class Decrypt {

    /**
     * 思路: 滑动窗口
     */
    class Solution {
        public int[] decrypt(int[] code, int k) {
            int len = code.length;
            int ans[] = new int[len];
            int e = k >= 0 ? (k == 0 ? 0 : 1) : -1;  //e取值为：[0,1,-1]
            for (int i = 0; i < len; i++) {
                int sum = 0;
                for (int j = e; j != k + e; j += e) {
                    sum += code[(i + j + len) % len];
                }
                ans[i] = sum;
            }
            return ans;
        }
    }
}
