package leetcode.editor.cn;

import java.util.Collections;

/**
 * @author Ayuan
 * @Description: 1592. 重新排列单词间的空格
 * @date 2022/9/7 09:48
 */
public class ReorderSpaces {
    public static void main(String[] args) {
        String text = "  walks  udp package   into  bar a";
        Solution solution = new ReorderSpaces().new Solution();
        System.out.println(solution.reorderSpaces(text));
    }

    class Solution {
        public String reorderSpaces(String text) {
            //1.分隔单词
            String[] arr = text.trim().split("\\s+");
            //2.统计单词个数
            int wordCnt = arr.length;
            //3.统计空格个数
            int spaceCnt = (int) text.chars().filter(x -> x == ' ').count();
            //4.统计单词之间的空格重复数
            int spaceRepeat = wordCnt <= 1 ? 0 : spaceCnt / (wordCnt - 1);
            //5.统计结尾多出来的空格数
            int lastRepeat = spaceCnt - spaceRepeat * (wordCnt - 1);
            //6.拼装返回
            return String.join(String.join("", Collections.nCopies(spaceRepeat, " ")), arr) + String.join("", Collections.nCopies(lastRepeat, " "));
        }
    }
}
