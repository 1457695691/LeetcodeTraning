package leetcode.editor.cn;

/**
 * 768. 最多能完成排序的块 II
 * 769. 最多能完成排序的块
 *
 * @author Ayuan
 */
public class MaxChunksToSorted {
    public static void main(String[] args) {
        MaxChunksToSorted.Solution solution = new MaxChunksToSorted().new Solution();
        int[] arr = {1, 0, 2, 3, 4};
        int out = solution.maxChunksToSorted(arr);
        System.out.println(out);
    }

    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int sum = 0, chunks = 0;
            //2.遍历数组
            for (int i = 0; i < arr.length; ++i) {
                //3.排好序后的值和下标应该相等，所以累加差值=0的时候就算一个块
                if ((sum += arr[i] - i) == 0) {
                    ++chunks;
                }
            }
            return chunks;
        }
    }
}
