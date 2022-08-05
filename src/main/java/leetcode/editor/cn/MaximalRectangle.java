package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 040. 矩阵中最大的矩形
 * @date 2022/8/5 15:40
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        MaximalRectangle.Solution solution = new MaximalRectangle().new Solution();
        String[] matrix = {"10100", "10111", "11111", "10010"};
        int out = solution.maximalRectangle(matrix);
        System.out.println(out);
    }

    class Solution {
        //看成每行求最大矩形面积，把每列的高度存个数组求个面积 最后算个谁的大就完事了
        public int maximalRectangle(String[] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length() == 0) {
                return 0;
            }
            // 把每一行以上的当作一个直方图计算
            int maxRectangle = 0;
            int[] row = new int[matrix[0].length()];
            for (String s : matrix) {
                for (int j = 0; j < matrix[0].length(); j++) {
                    row[j] = (s.charAt(j) == '0') ? 0 : (row[j] + 1);
                }
                maxRectangle = Math.max(maxRectangle, largestRectangleArea(row));
            }
            return maxRectangle;
        }

        private int largestRectangleArea(int[] heights) {
            int[] tmp = new int[heights.length + 2];
            System.arraycopy(heights, 0, tmp, 1, heights.length);
            Deque<Integer> stack = new ArrayDeque<>();
            int area = 0;
            for (int i = 0; i < tmp.length; ++i) {
                while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                    int height = tmp[stack.pop()];
                    area = Math.max(area, (i - stack.peek() - 1) * height);
                }
                stack.push(i);
            }
            return area;
        }
    }
}
