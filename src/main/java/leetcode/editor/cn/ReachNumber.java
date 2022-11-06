package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 754. 到达终点数字
 * @date 2022/11/4 09:28
 */
public class ReachNumber {
    class Solution {
        public int reachNumber(int target) {
            //1.取target绝对值好计算
            int total = Math.abs(target);
            //2.num从1开始自增，result计算总和
            int result = 0, num = 0;
            //3.直到num值大于等于total，并且num减total是偶数，才结束while循环
            while (num < total || (num - total) % 2 != 0) {
                num += ++result;
            }
            return result;
        }
    }
}
