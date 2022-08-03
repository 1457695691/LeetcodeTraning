package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 015. 字符串中的所有变位词
 * 438. 找到字符串中所有字母异位词
 * @date 2022/8/3 12:03
 */
public class FindAnagrams {
    public static void main(String[] args) {
        FindAnagrams.Solution solution = new FindAnagrams().new Solution();
        List<Integer> out = solution.findAnagrams("cbaebabacd", "abc");
        System.out.println(out.toString());
    }

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            // 用于返回字母异位词的起始索引
            List<Integer> res = new ArrayList<>();
            // 用 map 存储目标值中各个单词出现的次数
            HashMap<Character, Integer> map = new HashMap<>(16);
            for (Character c : p.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            // 用另外一个 map 存储滑动窗口中有效字符出现的次数
            HashMap<Character, Integer> window = new HashMap<>(16);
            int left = 0, right = 0, vaild = p.length();
            while (right < s.length()) {
                // 如果目标子串中包含了该字符，才存入 window 中
                if (map.containsKey(s.charAt(right))) {
                    window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                    // 只有当 window 中该有效字符数量不大于map中该字符数量，才能算一次有效包含
                    if (window.get(s.charAt(right)) <= map.get(s.charAt(right))) {
                        vaild--;
                    }
                }
                // 如果 window 符合要求，即两个 map 存储的有效字符相同，就可以移动左指针了
                // 但是只有二个map存储的数据完全相同，才可以记录当前的起始索引，也就是left指针所在位置
                while (vaild == 0) {
                    if (right - left + 1 == p.length()) {
                        res.add(left);
                    }
                    // 如果左指针指的是有效字符,需要更改 window 中的 key 对应的 value
                    // 如果 有效字符对应的数量比目标子串少，说明无法匹配了
                    if (map.containsKey(s.charAt(left))) {
                        window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 0) - 1);
                        if (window.get(s.charAt(left)) < map.get(s.charAt(left))) {
                            vaild++;
                        }
                    }
                    left++;
                }
                right++;
            }
            return res;
        }
    }
}
