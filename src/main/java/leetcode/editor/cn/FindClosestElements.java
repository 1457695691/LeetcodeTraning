package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 658. 找到 K 个最接近的元素
 * @date 2022/8/25 09:28
 */
public class FindClosestElements {
    public static void main(String[] args) {
        FindClosestElements.Solution solution = new FindClosestElements().new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> out = solution.findClosestElements(arr, k, x);
        System.out.println(out.toString());
    }


    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> arrayList = new ArrayList<>();
            for (int n : arr) {
                arrayList.add(n);
            }
            if (Collections.min(arrayList) >= x) {
                return arrayList.subList(0, k);
            }
            if (Collections.max(arrayList) <= x) {
                return arrayList.subList(arr.length - k, arr.length);
            }
            arrayList.sort((a, b) -> {
                if (Math.abs(a - x) != Math.abs(b - x)) {
                    return Math.abs(a - x) - Math.abs(b - x);
                } else {
                    return a - b;
                }
            });
            List<Integer> res = arrayList.subList(0, k);
            Collections.sort(res);
            return res;
        }
    }
}
