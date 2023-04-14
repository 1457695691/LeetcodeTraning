package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 1023. 驼峰式匹配
 * @date 2023/4/14 10:01
 */
public class CamelMatch {
    public static void main(String[] args) {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FoBa";
        CamelMatch.Solution solution = new CamelMatch().new Solution();
        List<Boolean> booleanList = solution.camelMatch(queries, pattern);
        booleanList.forEach(System.out::println);
    }

    class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> res = new ArrayList<>();
            for (String query : queries) {
                int i = 0;
                boolean flag = true;
                for (char c : query.toCharArray()) {
                    //如果是大写字母就遍历
                    if (Character.isUpperCase(c)) {
                        if (i != pattern.length()) {
                            if (pattern.charAt(i) == c) {
                                i++;
                            } else {
                                flag = false;
                                break;
                            }
                        } else {
                            flag = false;
                            break;
                        }
                    } else {
                        //不是大写字母->判等
                        if (i < pattern.length() && pattern.charAt(i) == c) {
                            i++;
                        }
                    }
                }
                if (i < pattern.length()) {
                    flag = false;
                }
                res.add(flag);
            }
            return res;
        }
    }
}
