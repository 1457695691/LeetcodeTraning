package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 636. 函数的独占时间
 *
 * @author Ayuan
 */
public class ExclusiveTime {
    public static void main(String[] args) {
        ExclusiveTime.Solution solution = new ExclusiveTime().new Solution();
        solution.exclusiveTime(1, new ArrayList<>());
    }

    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            Stack<int[]> stack = new Stack<>();
            int[] res = new int[n];
            for (String it : logs) {
                String[] split = it.split(":");
                //push stack
                if ("start".equals(split[1])) {
                    stack.push(new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[2])});
                } else {
                    int[] pop = stack.pop();
                    int time = Integer.parseInt(split[2]) - pop[1];
                    res[pop[0]] += time;
                    if (!stack.isEmpty()) {
                        res[stack.peek()[0]] -= time;
                    }

                }
            }
            return res;
        }
    }
}
