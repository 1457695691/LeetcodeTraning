package leetcode.editor.cn;

/**
 * 1953. 你可以工作的最大周数
 */
public class NumberOfWeeks {
    public static void main(String[] args) {
        int[] milestones = {1, 2, 3};
        NumberOfWeeks.Solution solution = new NumberOfWeeks().new Solution();
        long out = solution.numberOfWeeks(milestones);
        System.out.println(out);
    }

    class Solution {
        public long numberOfWeeks(int[] milestones) {
            long ans=0,max=0;
            for (int i : milestones) {
                ans+=i;
                max = Math.max(max,i);
            }
            if (ans >= 2*max-1) return ans;
            else return 2*(ans-max)+1;
        }
    }
}
