package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2582. 递枕头
 * @date 2023/9/26 09:48
 */
public class PassThePillow {
    class Solution {
        public int passThePillow(int n, int time) {
            return (time / (n - 1) & 1) == 0 ? time % (n - 1) + 1 : n - (time % (n - 1));
        }
    }
}
