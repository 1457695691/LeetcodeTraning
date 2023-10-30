package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 275. H 指数 II
 * @date 2023/10/30 09:58
 */
public class HIndex {
    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int left = 0, right = n;
            while (left < right) {
                int mid = left + right >> 1;
                int cnt = n - mid;
                if (citations[mid] < cnt) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return n - left;
        }
    }
}
