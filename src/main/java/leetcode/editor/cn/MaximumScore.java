package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1753. 移除石子的最大得分
 * @date 2022/12/21 09:32
 */
public class MaximumScore {
    class Solution {
        public int maximumScore(int a, int b, int c) {
            int[] arr = new int[3];
            arr[0] = a;
            arr[1] = b;
            arr[2] = c;
            Arrays.sort(arr);
            if (arr[0] + arr[1] <= arr[2]) {
                return arr[0] + arr[1];
            }
            return (arr[0] + arr[1] - arr[2]) / 2 + arr[2];
        }
    }
}
