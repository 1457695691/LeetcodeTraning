package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 1636. 按照频率将数组升序排序
 * @date 2022/9/19 09:35
 */
public class FrequencySort {


    class Solution {
        public int[] frequencySort(int[] nums) {
            int[] cnt = new int[210];
            for (int num : nums) {
                cnt[num + 100]++;
            }
            Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);

            Arrays.sort(array, (n1, n2) -> {
                if (cnt[n1 + 100] != cnt[n2 + 100]) {
                    return cnt[n1 + 100] - cnt[n2 + 100];
                }
                return n2 - n1;
            });
            return Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
        }
    }
}
