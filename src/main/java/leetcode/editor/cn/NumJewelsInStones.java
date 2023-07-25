package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 771. 宝石与石头
 * @date 2023/7/24 10:40
 */
public class NumJewelsInStones {

    class Solution {
        public int numJewelsInStones(String J, String S) {
            int count = 0;
            for (int i = 0; i < S.length(); i++) {
                if (J.contains(String.valueOf(S.charAt(i)))) {
                    count++;
                }
            }
            return count;
        }
    }
}
