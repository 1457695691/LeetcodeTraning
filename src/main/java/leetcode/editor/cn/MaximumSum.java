package leetcode.editor.cn;


/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/6/27 10:13
 */
public class MaximumSum {
    public static void main(String[] args) {
        MaximumSum.Solution solution = new MaximumSum().new Solution();
        int[] arr = {1, -2, 0, 3};
        int i = solution.maximumSum(arr);
        System.out.println(i);
    }

    class Solution {
        public int maximumSum(int[] arr) {
            int ori = arr[0], del = 0, sum = ori;
            for (int i = 1; i < arr.length; i++) {
                del = Math.max(ori, del + arr[i]);
                ori = Math.max(ori + arr[i], arr[i]);
                sum = Math.max(sum, Math.max(del, ori));
            }
            return sum;
        }
    }
}
