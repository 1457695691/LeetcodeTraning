package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 768. 最多能完成排序的块 II
 *
 * @author Ayuan
 */
public class MaxChunksToSorted {
    public static void main(String[] args) {
        MaxChunksToSorted.Solution solution = new MaxChunksToSorted().new Solution();
        int[] arr = {5, 4, 3, 2, 1};
        int out = solution.maxChunksToSorted(arr);
        System.out.println(out);
    }

    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int[] copy = arr.clone();
            Arrays.sort(copy);
            int pref = 0, chunks = 0;
            for (int i = 0; i < arr.length; ++i) {
                if ((pref += arr[i] - copy[i]) == 0) {
                    ++chunks;
                }
            }
            return chunks;
        }
    }
}
