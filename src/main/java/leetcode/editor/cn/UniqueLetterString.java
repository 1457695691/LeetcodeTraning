package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 828. 统计子串中的唯一字符
 * @date 2022/9/6 09:39
 */
public class UniqueLetterString {
    public static void main(String[] args) {
        UniqueLetterString.Solution solution = new UniqueLetterString().new Solution();
        int out = solution.uniqueLetterString("BCADEAFGA");
        System.out.println(out);
    }


    class Solution {
        public int uniqueLetterString(String s) {
            int[][] index = new int[26][2];
            //初始化，虚拟一个相同值为-1
            for (int i = 0; i < 26; i++) {
                Arrays.fill(index[i], -1);
            }
            int res = 0;
            //s[i]的前向子串对结果的贡献K
            int k = 0;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'A';
                // a，b分别为距离最近i的字母s[i]出现的先后两个位置
                int a = index[idx][0];
                int b = index[idx][1];
                //s[i]前向子串的贡献K+(i-b)-(b-a)
                k = k + (i - b) - (b - a);
                // 统计结果
                res += k;
                // 更新a，b的值
                index[idx][0] = index[idx][1];
                index[idx][1] = i;
            }
            return res;
        }
    }
}
