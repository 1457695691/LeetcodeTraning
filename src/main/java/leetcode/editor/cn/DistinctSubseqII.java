package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 940. 不同的子序列 II
 * @date 2022/10/14 09:26
 */
public class DistinctSubseqII {

    class Solution {
        public int distinctSubseqII(String s) {
            int mod = (int) 1e9 + 7;
            long[] dp = new long[26];
            for (int i = 0; i < s.length(); i++) {
                //以26个字母为结尾的子序列的数量（就是把当前字符串加到所有子序列的前面） + 1（自身）
                dp[s.charAt(i) - 'a'] = (1 + Arrays.stream(dp).sum()) % mod;
            }
            return (int) (Arrays.stream(dp).sum() % mod);
        }
    }

    class Solution2 {
        public int distinctSubseqII(String s) {
            int mod = (int) 1e9 + 7;
            int n = s.length();
            //之前新增的个数
            int[] preCount = new int[26];
            int curAns = 1;
            char[] chs = s.toCharArray();
            for (int i = 0; i < n; i++) {
                //新增的个数
                int newCount = curAns;
                //当前序列的个数 = 之前的 + 新增的 - 重复的
                curAns = ((curAns + newCount) % mod - preCount[chs[i] - 'a'] % mod + mod) % mod;
                //记录当前字符的 新增值
                preCount[chs[i] - 'a'] = newCount;
            }
            //减去空串
            return curAns - 1;
        }
    }
}
