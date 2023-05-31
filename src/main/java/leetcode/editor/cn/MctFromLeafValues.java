package leetcode.editor.cn;

import java.util.ArrayList;

/**
 * @author Ayuan
 * @Description: 1130. 叶值的最小代价生成树
 * @date 2023/5/31 10:57
 */
public class MctFromLeafValues {
    /**
     * 贪心
     * 进行arr.size()-1次以下操作，直到arr中只含1个数：
     * 选择相邻乘积最小的两个数，累加此乘积到答案，删除较小那个，保留较大那个，更新arr
     * 继续遍历arr，选择相邻乘积最小，依次类推。
     */
    class Solution {
        public int mctFromLeafValues(int[] arr) {
            int res = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i : arr) {
                list.add(i);
            }
            while (list.size() > 1) {
                int idx = 0;
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i) * list.get(i + 1) < list.get(idx) * list.get(idx + 1)) {
                        idx = i;
                    }
                }
                res += list.get(idx) * list.get(idx + 1);
                if (list.get(idx) < list.get(idx + 1)) {
                    list.remove(idx);
                } else {
                    list.remove(idx + 1);
                }
            }
            return res;
        }
    }
}
