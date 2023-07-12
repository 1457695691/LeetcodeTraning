package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2544. 交替数字和
 * @date 2023/7/12 10:09
 */
public class AlternateDigitSum {
    public int alternateDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            //计算交替差的累积值
            sum = n % 10 - sum;
            n /= 10;
        }
        return sum;
    }
}
