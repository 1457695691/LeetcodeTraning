package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 016. 不含重复字符的最长子字符串
 * @date 2022/8/5 09:34
 */
public class LengthOfLongestSubstring {


    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 滑动窗口解法
            Set<Character> occ = new HashSet<Character>();
            int n = s.length();
            int rk = -1, ans = 0;
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    // 左指针右移，移除字符
                    occ.remove(s.charAt(i - 1));
                }
                while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                    // 右指针右移，记录当前最大无重复子串
                    occ.add(s.charAt(rk + 1));
                    rk++;
                }
                // 当前最大无重复子串
                ans = Math.max(ans, rk - i + 1);
            }

            return ans;
        }
    }
}
