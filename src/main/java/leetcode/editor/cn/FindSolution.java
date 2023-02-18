package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 1237. 找出给定方程的正整数解
 * @date 2023/2/18 09:38
 */
public class FindSolution {

    /**
     * 双指针
     */
    class Solution {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> res = new ArrayList<>();
            int x = 1, y = z;
            while (y > 0 && x <= z) {
                int f = customfunction.f(x, y);
                if (f == z) {
                    res.add(Arrays.asList(x++, y--));
                } else if (f > z) {
                    y--;
                } else {
                    x++;
                }
            }
            return res;
        }
    }
}

interface CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    int f(int x, int y);
}
