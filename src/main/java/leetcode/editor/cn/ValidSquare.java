package leetcode.editor.cn;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 593. 有效的正方形
 * @date 2022/7/29 09:53
 */
public class ValidSquare {
    public static void main(String[] args) {
        int[] p1 = {0, 0}, p2 = {1, 1}, p3 = {1, 0}, p4 = {0, 1};
        ValidSquare.Solution solution = new ValidSquare().new Solution();
        boolean out = solution.validSquare(p1, p2, p3, p4);
        System.out.println(out);
    }

    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            // 中心点缩放四倍
            int[] center = new int[2];
            center[0] = p1[0] + p2[0] + p3[0] + p4[0];
            center[1] = p1[1] + p2[1] + p3[1] + p4[1];
            move(p1, center);
            move(p2, center);
            move(p3, center);
            move(p4, center);


            List<int[]> list = new ArrayList<>();
            list.add(p1);
            list.add(p2);
            list.add(p3);
            list.add(p4);

            int count = 0;
            for (int[] p : list) {
                for (int[] pp : list) {
                    if (pp[0] == -p[1] && pp[1] == p[0]) {
                        count++;
                    }
                }
            }
            return count == 4;
        }

        //移动到中心原点
        public void move(int[] p, int[] center) {
            p[0] = p[0] * 4 - center[0];
            p[1] = p[1] * 4 - center[1];
        }
    }
}
