package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 761. 特殊的二进制序列
 * @date 2022/8/8 12:41
 */
public class MakeLargestSpecial {
    public static void main(String[] args) {
        MakeLargestSpecial.Solution solution = new MakeLargestSpecial().new Solution();
        String out = solution.makeLargestSpecial("");
        //right ："11100100"
        System.out.println(out);
    }

    class Solution {
        //转变为括号问题
        public String makeLargestSpecial(String s) {
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>();
            int start = 0;
            int count = 0;
            for (int i = 0; i < s.length(); ++i) {
                count += s.charAt(i) == '1' ? 1 : -1;
                if (count == 0) {
                    String str = s.substring(start + 1, i);
                    list.add("1" + makeLargestSpecial(str) + "0");
                    start = i + 1;
                }
            }
            Collections.sort(list);
            for (int i = list.size() - 1; i >= 0; --i) {
                sb.append(list.get(i));
            }
            return sb.toString();
        }
    }
}
