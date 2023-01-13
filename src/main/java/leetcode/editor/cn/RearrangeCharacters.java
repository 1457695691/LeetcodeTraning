package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 2287. 重排字符形成目标字符串
 * @date 2023/1/13 10:33
 */
public class RearrangeCharacters {
    class Solution {
        public int rearrangeCharacters(String s, String target) {
            int res = Integer.MAX_VALUE;
            //1.初始化s的map1
            Map<Character, Integer> map1 = new HashMap<>();
            for (char c : s.toCharArray()) {
                map1.put(c, map1.getOrDefault(c, 0) + 1);
            }
            //2.初始化target的map2
            Map<Character, Integer> map2 = new HashMap<>();
            for (char c : target.toCharArray()) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
            }
            //3.遍历map2中的key，相除取最小倍数
            for (char key : map2.keySet()) {
                if (map1.containsKey(key)) {
                    res = Math.min(res, map1.get(key) / map2.get(key));
                } else {
                    return 0;
                }
            }
            return res;
        }
    }
}
