package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2559. 统计范围内的元音字符串数
 * @date 2023/6/2 10:48
 */
public class VowelStrings {
    class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            int n = words.length;
            int[] board = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int sum = 0;
                switch (words[i].charAt(0)) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        sum++;
                }
                if (sum > 0) {
                    switch (words[i].charAt(words[i].length() - 1)) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                            sum++;
                    }
                }
                if (sum == 2) {
                    board[i + 1] = board[i] + 1;
                } else {
                    board[i + 1] = board[i];
                }
            }
            int m = queries.length;
            int[] res = new int[m];
            for (int i = 0; i < m; i++) {
                res[i] = board[queries[i][1] + 1] - board[queries[i][0]];
            }
            return res;
        }
    }
}
