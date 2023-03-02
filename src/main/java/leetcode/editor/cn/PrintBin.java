package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 面试题 05.02. 二进制数转字符串
 * @date 2023/3/2 15:31
 */
public class PrintBin {
    class Solution {
        public String printBin(double num) {
            StringBuilder sb = new StringBuilder("0.");
            int count = 0;
            while (num != 0 && count < 32) {
                num = num * 2;
                sb.append(num >= 1 ? 1 : 0);
                num = num >= 1 ? num - 1 : num;
                count++;
            }
            if (num != 0) {
                return "ERROR";
            }
            return sb.toString();
        }
    }
}
