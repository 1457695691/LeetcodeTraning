package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ayuan
 * @Description: 2363. 合并相似的物品
 * @date 2023/2/28 09:48
 */
public class MergeSimilarItems {
    class Solution {
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            List<List<Integer>> collect = Stream.concat(Arrays.stream(items1), Arrays.stream(items2))
                    .collect(Collectors.toMap(k -> k[0], v -> v[1], Integer::sum))
                    .entrySet().stream()
                    .map(entry -> Arrays.asList(entry.getKey(), entry.getValue()))
                    .sorted(Comparator.comparing(i -> i.get(0)))
                    .collect(Collectors.toList());
            return collect;
        }
    }
}
