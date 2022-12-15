package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1945. 字符串转化后的各位数字之和
 * @date 2022/12/15 09:36
 */
public class GetLucky {
    class Solution {
        public int getLucky(String s, int k) {
            //1.拼字符串
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(c - 'a' + 1);
            }
            //2.模拟循环k次相加
            while (--k >= 0) {
                int temp = 0;
                for (char c : sb.toString().toCharArray()) {
                    temp += c - '0';
                }
                sb.delete(0, sb.length());
                sb.append(temp);
            }
            return Integer.parseInt(sb.toString());
        }
    }
}
