package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. 用户分组
 *
 * @author Ayuan
 */
public class GroupThePeople {
    public static void main(String[] args) {
        GroupThePeople.Solution solution = new GroupThePeople().new Solution();
        int[] gs1 = {3, 3, 3, 3, 3, 1, 3};
        int[] gs2 = {2, 1, 3, 3, 3, 2};
        List<List<Integer>> out1 = solution.groupThePeople(gs1);
        //输出：[[5],[0,1,2],[3,4,6]]
        System.out.println(out1);
        List<List<Integer>> out2 = solution.groupThePeople(gs2);
        //输出：[[1],[0,5],[2,3,4]]
        System.out.println(out2);
    }

    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            List<List<Integer>> res = new ArrayList<>();
            Map<Integer, List<Integer>> map = new HashMap<>(16);
            for (int i = 0; i < groupSizes.length; ++i) {
                //k为list大小 v为下标
                map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>()).add(i);
                //容量
                if (groupSizes[i] == map.get(groupSizes[i]).size()) {
                    res.add(map.remove(groupSizes[i]));
                }
            }
            return res;
        }
    }
}
