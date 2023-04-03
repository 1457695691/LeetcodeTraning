package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1053. 交换一次的先前排列
 * @date 2023/4/3 09:35
 */
public class PrevPermOpt1 {
    class Solution {
        public int[] prevPermOpt1(int[] arr) {
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    int max = i + 1;
                    for (int j = i + 2; j < arr.length && arr[j] < arr[i]; j++) {
                        if (arr[max] < arr[j]) max = j;
                    }
                    arr[i] = arr[i] ^ arr[max];
                    arr[max] = arr[i] ^ arr[max];
                    arr[i] = arr[i] ^ arr[max];
                    break;
                }
            }
            return arr;
        }
    }
}
