package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2485. 找出中枢整数
 * @date 2022/12/13 10:09
 */
public class PivotInteger {
    public static void main(String[] args) {
        PivotInteger.Solution solution = new PivotInteger().new Solution();
        int i = solution.pivotInteger(8);
        System.out.println(i);
    }

    class Solution {
        public int pivotInteger(int n) {
            if (n == 1) return 1;
            int sum = 0;
            for (int i = 1; i < n; i++) {
                //从i加到n
                sum += i;
                if (n * (n + 1) / 2 - sum + i == sum) {
                    return i;
                }
            }
            return -1;
        }
    }
}
