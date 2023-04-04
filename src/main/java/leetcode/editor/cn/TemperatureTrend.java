package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: LCP 61. 气温变化趋势
 * @date 2023/4/4 13:59
 */
public class TemperatureTrend {
    class Solution {
        public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
            int[] tempA = new int[temperatureA.length - 1];
            int[] tempB = new int[temperatureB.length - 1];
            for (int i = 0; i < temperatureA.length - 1; i++) {
                //记录A变化趋势
                int a = temperatureA[i + 1] - temperatureA[i];
                if (a > 0) {
                    tempA[i] = 1;
                } else if (a < 0) {
                    tempA[i] = -1;
                } else {
                    tempA[i] = 0;
                }
                //记录B变化趋势
                int b = temperatureB[i + 1] - temperatureB[i];
                if (b > 0) {
                    tempB[i] = 1;
                } else if (b < 0) {
                    tempB[i] = -1;
                } else {
                    tempB[i] = 0;
                }
            }
            int max = 0;
            int count = 0;
            for (int i = 0; i < tempA.length; i++) {
                if (tempA[i] == tempB[i]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 0;
                }
            }
            return max;
        }
    }
}
