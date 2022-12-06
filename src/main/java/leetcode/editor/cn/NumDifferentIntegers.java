package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ayuan
 * @Description: 1805. 字符串中不同整数的数目
 * @date 2022/12/6 09:21
 */
public class NumDifferentIntegers {

    class Solution {
        public int numDifferentIntegers(String word) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c < 58) {
                    int j = i;
                    while (j < word.length() && word.charAt(j) < 58) {
                        j++;
                    }
                    while (i < j && word.charAt(i) == 48) {
                        i++;
                    }
                    set.add(word.substring(i, j));
                    i = j;
                }

            }
            return set.size();
        }
    }
}
