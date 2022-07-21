package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 014. 字符串中的变位词
 * @date 2022/7/20 15:24
 */
public class CheckInclusion {

    private static final int LETTER_COUNT = 26;

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            // 获取第一个字符串中包含的每个字母的个数
            int[] targetLetterCount = getLetterCount(s1.toCharArray());
            int targetLength = s1.length();
            char[] sArr = s2.toCharArray();
            // 记录滑动窗口中每个字母的个数
            int[] windowLetterCount = new int[LETTER_COUNT];

            for (int left = 0, right = 0, length = s2.length(); right < length; right++) {
                int index = getIndex(sArr[right]);
                // 将窗口右端向右移动一格，将新的字母保存到滑动窗口中
                windowLetterCount[index]++;
                // 窗口长度适宜且窗口内当前字母的个数等于需要的个数
                if (targetLength == right - left + 1 && windowLetterCount[index] == targetLetterCount[index]) {
                    return true;
                }
                // 收缩窗口，条件是保证窗口仍然存在，且窗口中该字母的个数比需要的个数多
                while (left <= right && windowLetterCount[index] > targetLetterCount[index]) {
                    windowLetterCount[getIndex(sArr[left++])]--;
                }
            }
            return false;
        }
    }


    private static int[] getLetterCount(char[] sArr) {
        int[] count = new int[LETTER_COUNT];
        for (char letter : sArr) {
            count[getIndex(letter)]++;
        }
        return count;
    }

    private static int getIndex(char letter) {
        return letter - 'a';
    }

    public static void main(String[] args) {
        CheckInclusion.Solution solution = new CheckInclusion().new Solution();
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean out = solution.checkInclusion(s1, s2);
        System.out.println(out);
    }
}
