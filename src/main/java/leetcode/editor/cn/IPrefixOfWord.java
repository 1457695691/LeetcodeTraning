package leetcode.editor.cn;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 *
 * @author Ayuan
 */
public class IPrefixOfWord {

    public static void main(String[] args) {
        IPrefixOfWord.Solution solution = new IPrefixOfWord().new Solution();
        String sentence = "pillow love winstontang i pillow corona you errichto love", searchWord = "i";
        int prefixOfWord = solution.isPrefixOfWord(sentence, searchWord);
        System.out.println(prefixOfWord);
//        boolean after = solution.isAfter("ell", "hellohello");
//        System.out.println(after);
    }

    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] s = sentence.split(" ");
            for (int i = 0; i < s.length; i++) {
                if (!s[i].contains(searchWord)) {
                    continue;
                }
                int j = 0;
                while (j < searchWord.length()) {
                    if (s[i].charAt(j) == searchWord.charAt(j)) {
                        j++;
                    } else {
                        break;
                    }
                }
                if (j == searchWord.length()) {
                    return i + 1;
                }
            }
            return -1;
        }
    }
}
