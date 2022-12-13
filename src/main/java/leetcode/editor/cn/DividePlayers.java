package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 2491. 划分技能点相等的团队
 * @date 2022/12/13 15:02
 */
public class DividePlayers {
    class Solution {
        public long dividePlayers(int[] skill) {
            Arrays.sort(skill);
            int n = skill.length;
            int sum = skill[0] + skill[n - 1];

            long res = 0L;
            for (int i = 0; i < n / 2; i++) {
                if (skill[i] + skill[n - 1 - i] != sum) {
                    return -1L;
                }
                res += (long) skill[i] * skill[n - 1 - i];
            }
            return res;
        }
    }
}
