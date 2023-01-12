package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 1807. 替换字符串中的括号内容
 * @date 2023/1/12 09:26
 */
public class Evaluate {
    class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            StringBuilder sb = new StringBuilder();
            //1.初始化哈希表
            Map<String, String> map = new HashMap<>();
            for (List<String> k : knowledge) {
                map.put(k.get(0), k.get(1));
            }
            //2.遍历s,遇到括号就找map里的值，找不到用？替换
            int index = 0;
            while (index < s.length()) {
                char c = s.charAt(index);
                //2.1遇到左括号就继续往右匹配
                if ('(' == c) {
                    StringBuilder str = new StringBuilder();
                    index++;
                    while (s.charAt(index) != ')') {
                        str.append(s.charAt(index));
                        index++;
                    }
                    sb.append(map.getOrDefault(str.toString(), "?"));
                } else {
                    sb.append(c);
                }
                index++;
            }
            return sb.toString();
        }
    }
}
