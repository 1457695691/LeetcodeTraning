package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 039. 直方图最大矩形面积
 * @date 2022/8/5 14:51
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
        LargestRectangleArea.Solution solution = new LargestRectangleArea().new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int out = solution.largestRectangleArea(heights);
        System.out.println(out);
    }

    class Solution {
        public int largestRectangleArea(int[] heights) {
            //拷贝数组 首位加0
            int[] tmp = new int[heights.length + 2];
            System.arraycopy(heights, 0, tmp, 1, heights.length);
            //构建单调栈
            Deque<Integer> stack = new ArrayDeque<>();
            int area = 0;
            for (int i = 0; i < tmp.length; i++) {
                // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
                // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
                while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                    int h = tmp[stack.pop()];
                    area = Math.max(area, (i - stack.peek() - 1) * h);
                }
                stack.push(i);
            }
            return area;
        }
    }
}
