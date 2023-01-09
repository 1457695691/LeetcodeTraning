package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1806. 还原排列的最少操作步数
 * @date 2023/1/9 09:43
 */
public class ReinitializePermutation {
    public static void main(String[] args) {
        ReinitializePermutation.Solution solution = new ReinitializePermutation().new Solution();
        int out = solution.reinitializePermutation(6);
        System.out.println(out);
    }


    class Solution {
        public int reinitializePermutation(int n) {
            //1.模拟原数组
            int[] perm = new int[n];
            int[] old = new int[n];
            for (int i = 0; i < n; i++) {
                perm[i] = i;
                old[i] = i;
            }
            //2.模拟目标数组
            int[] arr = new int[n];
            int count = 0;
            do {
                //3.模拟过程
                for (int i = 0; i < n; i++) {
                    arr[i] = i % 2 == 0 ? perm[i / 2] : perm[n / 2 + (i - 1) / 2];
                }
                count++;
                perm = arr.clone();
            } while (!Arrays.equals(perm, old));
            return count;
        }
    }
}
