package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 2451. 差值数组不同的字符串
 * @date 2023/5/25 09:52
 */
public class OddString {
    class Solution {
        public String oddString(String[] words) {
            int n = words.length;
            Map<String, Integer> map = new HashMap<>();
            Map<String, String> m = new HashMap<>();
            for (String word : words) {
                int[] dif = new int[n - 1];
                for (int i = 0; i < word.length() - 1; i++) {
                    dif[i] = word.charAt(i + 1) - word.charAt(i);
                }
                String str = Arrays.toString(dif);
                map.put(str, map.getOrDefault(str, 0) + 1);
                m.put(str, word);
            }
            for (String key : map.keySet()) {
                if (map.get(key).equals(1)) {
                    return m.get(key);
                }
            }
            return "";
        }
    }
}