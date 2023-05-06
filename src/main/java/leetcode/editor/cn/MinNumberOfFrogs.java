package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1419. 数青蛙
 * @date 2023/5/6 09:56
 */
public class MinNumberOfFrogs {
    class Solution {
        public int minNumberOfFrogs(String croakOfFrogs) {
            int[] arr = new int[26];
            int result = 0;
            for (int i = 0; i < croakOfFrogs.length(); i++) {
                arr[croakOfFrogs.charAt(i) - 'a']++;
                int c = arr['c' - 'a'];
                int r = arr['r' - 'a'];
                int o = arr['o' - 'a'];
                int a = arr[0];
                int k = arr['k' - 'a'];
                if (c < r || r < o || o < a || a < k) {
                    return -1;
                }
                if (croakOfFrogs.charAt(i) == 'c') {
                    result = Math.max(result, c - k);
                }
            }
            int c = arr['c' - 'a'];
            int r = arr['r' - 'a'];
            int o = arr['o' - 'a'];
            int a = arr[0];
            int k = arr['k' - 'a'];
            if (c != r || r != o || o != a || a != k) {
                return -1;
            }
            return result;
        }
    }
}
