package leetcode.editor.cn;

import org.thymeleaf.expression.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 310. 最小高度树
 */
public class FindMinHeightTrees {

    public static void main(String[] args) {
        Solution solution = new FindMinHeightTrees().new Solution();
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        List<Integer> minHeightTrees = solution.findMinHeightTrees(n, edges);
        System.out.println(minHeightTrees);
    }

    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 1) return new ArrayList<Integer>(){};
            List<Integer> result = new ArrayList<>();
            


            return result;
        }
    }
}
