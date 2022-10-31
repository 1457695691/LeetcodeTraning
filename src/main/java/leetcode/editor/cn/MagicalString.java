package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 481. 神奇字符串
 * @date 2022/10/31 09:32
 */
public class MagicalString {
    class Solution {
        public int magicalString(int n) {
            int[] magic = new int[n + 1]; // 用于存储神奇数字集合
            magic[0] = 1; // 初始化第1个元素为0
            int tail = 1, p = 1, result = 1, value = 1, count = 2;
            while (tail < n) {
                value = value ^ 3; // 确定第"p"组内元素的值"value"是多少。(通过与3异或，可以将1和2互换)
                while (count-- > 0 && tail < n) { // 循环创建第"p"组内的"count"个元素，每个元素的值都是"value"
                    magic[tail++] = value;
                    if (value == 1) result++; // 如果发现元素的值"value"是1，则将"result"加1
                }
                count = magic[++p]; // 创建完第"p"组所有元素之后，获得下一组(即："p+1")需要创建的数字个数"count"
            }
            return result;
        }
    }
}
