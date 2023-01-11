package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 2283. 判断一个数的数字计数是否等于数位的值
 * @date 2023/1/11 09:38
 */
public class DigitCount {
    class Solution {
        public boolean digitCount(String num) {
            Map<Integer, Integer> map = new HashMap<>();
            char[] chars = num.toCharArray();
            for (char c : chars) {
                map.put(c - '0', map.getOrDefault(c - '0', 0) + 1);
            }
            for (int i = 0; i < chars.length; i++) {
                if (map.getOrDefault(i, 0) != (chars[i] - '0')) {
                    return false;
                }
            }
            return true;
        }
    }
}
