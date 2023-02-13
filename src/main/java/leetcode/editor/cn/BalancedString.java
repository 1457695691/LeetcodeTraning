package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1234. 替换子串得到平衡字符串
 * @date 2023/2/13 13:35
 */
public class BalancedString {

    /**
     * 滑动窗口
     */
    class Solution {
        public int balancedString(String s) {
            char[] chars = s.toCharArray();
            int[] cnt = new int['X']; // 也可以用哈希表，不过数组更快一些
            for (char c : chars) ++cnt[c];
            int n = chars.length, m = n / 4;
            if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m)
                return 0; // 已经符合要求啦
            int ans = n, left = 0;
            for (int right = 0; right < n; right++) { // 枚举子串右端点
                --cnt[chars[right]];
                while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                    ans = Math.min(ans, right - left + 1);
                    ++cnt[chars[left++]]; // 缩小子串
                }
            }
            return ans;
        }
    }
}
