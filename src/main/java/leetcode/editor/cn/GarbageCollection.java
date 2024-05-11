package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 2391. 收集垃圾的最少总时间
 */
public class GarbageCollection {
    public static void main(String[] args) {
        Solution solution = new GarbageCollection().new Solution();
        String[] garbage = {"G", "P", "GP", "GG"};
        int[] travel = {2, 4, 3};
        int res = solution.garbageCollection(garbage, travel);
        System.out.println(res);//21
    }

    class Solution {
        public int garbageCollection(String[] garbage, int[] travel) {
            int ans = garbage[0].length();
            Set<Character> seen = new HashSet<>();
            for (int i = garbage.length - 1; i > 0; i--) {
                char[] g = garbage[i].toCharArray();
                for (char c : g) {
                    seen.add(c);
                }
                ans += g.length + travel[i - 1] * seen.size();
            }
            return ans;
        }
    }
}
