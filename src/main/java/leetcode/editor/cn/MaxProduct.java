package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 005. 单词长度的最大乘积
 * @date 2022/7/18 16:00
 */
public class MaxProduct {
    /**
     * 1.考虑二进制值 与 的特性
     * 0 & 0 = 0
     * 0 & 1 = 1 & 0 = 0
     * 1 & 1 =1
     * <p>
     * 2.用一个数字二进制表示中的每一位记录一个字母是否出现，例如，字符串 ac 可以用 00000000 00000000 00000000 00000101 = 3 表示
     * 3.将每一个字符串中字母是否出现均用一个数字表示表示出来，当比较两个字符串是否存在相同字母时，使用 num1 & num2 == 0 就可以轻易判断出来了
     */
    public static void main(String[] args) {
        MaxProduct.Solution solution = new MaxProduct().new Solution();
        String[] test1 = {"abcw", "baz", "foo", "bar", "fxyz", "abcdef"};
        String[] test2 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        String[] test3 = {"a", "aa", "aaa", "aaaa"};
        int out = solution.maxProduct(test1);
        System.out.println(out);
    }

    class Solution {
        public int maxProduct(String[] words) {
            int result = 0;
            int[] wordCode = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                for (char letter : words[i].toCharArray()) {
                    wordCode[i] |= (1 << (letter - 'a'));
                }
            }
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (0 == (wordCode[i] & wordCode[j])) {
                        result = Math.max(result, words[i].length() * words[j].length());
                    }
                }
            }
            return result;
        }
    }
}
