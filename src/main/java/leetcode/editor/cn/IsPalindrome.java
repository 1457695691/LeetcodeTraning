package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 018. 有效的回文
 * @date 2022/7/22 10:26
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome.Solution solution = new IsPalindrome().new Solution();
        String s = "A man, a plan, a canal: Panama";
        boolean out = solution.isPalindrome(s);
        System.out.println(out);
    }

    class Solution {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;
            while (left <= right) {
                //判断字符是不是字母或数字
                if (!Character.isLetterOrDigit(s.charAt(left))) {
                    left += 1;
                } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                    right -= 1;
                } else {
                    //将大写字符转换成小写字符
                    char char1 = Character.toLowerCase(s.charAt(left++));
                    char char2 = Character.toLowerCase(s.charAt(right--));
                    if (char1 != char2) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
