package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 1640. 能否连接形成数组
 * @date 2022/9/22 09:56
 */
public class CanFormArray {

    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            Map<Integer, int[]> map = new HashMap<>();
            for (int[] piece : pieces) {
                map.put(piece[0], piece);
            }

            for (int i = 0; i < arr.length;) {
                if (!map.containsKey(arr[i])) {
                    return false;
                }
                int[] array = map.get(arr[i]);
                for (int j = 0; j < array.length; j++, i++) {
                    if (arr[i] != array[j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
