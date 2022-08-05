package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 038. 每日温度
 * 739
 * @date 2022/8/5 14:32
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures.Solution solution = new DailyTemperatures().new Solution();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] out = solution.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(out));
    }

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            //单调栈
            Stack<Integer> monoStack = new Stack<>();
            int[] ans = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                while (!monoStack.isEmpty() && temperatures[monoStack.peek()] < temperatures[i]) {
                    Integer smallIdx = monoStack.pop();
                    ans[smallIdx] = i - smallIdx;
                }
                monoStack.push(i);
            }
            return ans;
        }
    }
}
