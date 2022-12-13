package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ayuan
 * @Description: 1832. 判断句子是否为全字母句
 * @date 2022/12/13 09:06
 */
public class CheckIfPangram {


    /**
     * 最简单解法
     */
    class Solution {
        public boolean checkIfPangram(String sentence) {
            Set<Character> set = new HashSet<>();
            for (char c : sentence.toCharArray()) {
                set.add(c);
            }
            return set.size() == 26;
        }
    }

    /**
     * 位运算
     */
    class Solution2 {
        public boolean checkIfPangram(String sentence) {
            //从低位起第 i 位为 1 表示出现了字母表中的第 i 个字母
            //只要最后的位运算结果为 26 个 1（即 3ffffffH）就说明这是个全字母句
            int bin = 0;
            for (char c : sentence.toCharArray()) {
                int which = 1 << (c - 'a');
                bin = which | bin;

            }
            return bin == 0x3ffffff;
        }
    }
}
