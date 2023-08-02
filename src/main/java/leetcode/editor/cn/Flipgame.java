package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ayuan
 * @Description: 822. 翻转卡片游戏
 * @date 2023/8/2 09:38
 */
public class Flipgame {
    class Solution {
        public int flipgame(int[] fronts, int[] backs) {
            Set<Integer> set = new HashSet<>();
            int n = fronts.length;
            for (int i = 0; i < n; i++) {
                if (fronts[i] == backs[i]) {
                    set.add(fronts[i]);
                }
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!set.contains(fronts[i])) {
                    res = Math.min(res, fronts[i]);
                }
                if (!set.contains(backs[i])) {
                    res = Math.min(res, backs[i]);
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }

    class Solution2 {
        public int flipgame(int[] fronts, int[] backs) {
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < fronts.length; i++) {
                set.add(fronts[i]);
                set.add(backs[i]);
            }
            for (int i = 0; i < fronts.length; i++) {
                if (fronts[i] == backs[i]) {
                    set.remove(fronts[i]);
                }
            }
            return set.size() == 0 ? 0 : set.iterator().next();
        }
    }

}
