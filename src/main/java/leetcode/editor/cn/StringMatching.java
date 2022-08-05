package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配
 *
 * @author Ayuan
 */
public class StringMatching {

    public static void main(String[] args) {
        StringMatching.Solution solution = new StringMatching().new Solution();
        String[] words = {"mass", "as", "hero", "superhero"};
        List<String> out = solution.stringMatching(words);
        System.out.println(out);
    }

    class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> res = new ArrayList<>();
            for (String word : words) {
                for (String s : words) {
                    if (word.length() >= s.length()) {
                        continue;
                    }
                    if (s.contains(word)) {
                        res.add(word);
                        break;
                    }
                }
            }
            return res;
        }
    }
}
