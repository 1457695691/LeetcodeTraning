package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 1090. 受标签影响的最大值
 * @date 2023/5/23 10:06
 */
public class LargestValsFromLabels {
    class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            List<Pair<Integer, Integer>> pairs = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            int j = 0;
            for (int i = 0; i < values.length; i++) {
                pairs.add(new Pair<>(values[i], labels[i]));
            }
            //从大到小排序
            pairs.sort((o1, o2) -> o2.getKey() - o1.getKey());
            //挨个拿，拿到不能拿为止
            while (numWanted > 0 && j < values.length) {
                map.put(pairs.get(j).getValue(), map.getOrDefault(pairs.get(j).getValue(), 0) + 1);
                if (map.get(pairs.get(j).getValue()) <= useLimit) {
                    count += pairs.get(j).getKey();
                    numWanted--;
                }
                j++;
            }
            return count;
        }
    }
}
