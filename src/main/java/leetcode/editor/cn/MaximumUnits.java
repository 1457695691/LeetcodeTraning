package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1710. 卡车上的最大单元数
 * @date 2022/11/15 09:36
 */
public class MaximumUnits {
    /**
     * 贪心
     */
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            //按照numberOfUnitsPerBox排序，大的在前
            Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
            int res = 0;
            for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
                //先看最大的那个数量够不够
                if (boxTypes[i][0] < truckSize) {
                    res += boxTypes[i][0] * boxTypes[i][1];
                    truckSize -= boxTypes[i][0];
                } else {
                    res += truckSize * boxTypes[i][1];
                    truckSize = 0;
                }

            }
            return res;
        }
    }
}
