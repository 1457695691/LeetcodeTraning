package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 667. 优美的排列 II
 * @date 2022/9/8 09:23
 */
public class ConstructArray {
    public static void main(String[] args) {
        Solution solution = new ConstructArray().new Solution();
        int[] out = solution.constructArray(5, 4);
        System.out.println(Arrays.toString(out));
    }

    class Solution {
        public int[] constructArray(int n, int k) {
            int[] res = new int[n];
            //1.先顺序填充个数组
            for (int i = 1; i <= n; i++) {
                res[i - 1] = i;
            }
            //2.当k=1的时候可以直接顺序返回
            if (k == 1) {
                return res;
            }
            //3.k != 1时,翻转数组
            for (int j = 1; j <= k; j++) {
                int index = n;
                for (int i = j - 1; i < index; i++) {
                    int temp = res[--index];
                    res[index] = res[i];
                    res[i] = temp;
                }
            }
            return res;
        }
    }
}
