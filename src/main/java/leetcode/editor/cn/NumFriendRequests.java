package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 825. 适龄的朋友
 * @date 2022/9/7 15:18
 */
public class NumFriendRequests {
    public static void main(String[] args) {
        Solution solution = new NumFriendRequests().new Solution();
        int[] ages = {20, 30, 100, 110, 120};
        int out = solution.numFriendRequests(ages);
        System.out.println(out);
    }

    class Solution {
        public int numFriendRequests(int[] ages) {
            int[] preSum = new int[125];
            for (int age : ages) {
                preSum[age]++;
            }
            for (int i = 1; i < 125; i++) {
                preSum[i] += preSum[i - 1];
            }
            int ans = 0, l = 0, r = 0;
            for (int i = 15; i <= 120; i++) {
                while (l <= 120 && 2 * l <= i + 14) {
                    l++;
                }
                while (l <= 120 && r <= i) {
                    r++;
                }
                ans += (preSum[r - 1] - preSum[l - 1] - 1) * (preSum[i] - preSum[i - 1]);
            }
            return ans;
        }
    }
}
