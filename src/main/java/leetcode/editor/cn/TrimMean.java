package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1619. 删除某些元素后的数组均值
 * @date 2022/9/14 09:23
 */
public class TrimMean {
    public static void main(String[] args) {
        TrimMean.Solution solution = new TrimMean().new Solution();
        int[] arr = {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
        double out = solution.trimMean(arr);
        System.out.println(out);
    }
    class Solution {
        public double trimMean(int[] arr) {
        double res = 0.00;
        Arrays.sort(arr);
        for (int i = arr.length/20; i < arr.length * 19/20; i++){
            res += arr[i];
        }
        return res/(arr.length* 9 / 10);
        }
    }
}