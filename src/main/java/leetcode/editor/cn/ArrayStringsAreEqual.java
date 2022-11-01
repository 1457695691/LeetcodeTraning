package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1662. 检查两个字符串数组是否相等
 * @date 2022/11/1 09:20
 */
public class ArrayStringsAreEqual {

    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            return Arrays.toString(word1).replace(", ","").equals(Arrays.toString(word2).replace(", ", ""));
        }
    }
}
