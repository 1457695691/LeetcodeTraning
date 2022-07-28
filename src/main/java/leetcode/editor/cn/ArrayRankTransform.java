package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 1331. 数组序号转换
 * @date 2022/7/28 11:09
 */
public class ArrayRankTransform {
    public static void main(String[] args) {
        ArrayRankTransform.Solution solution = new ArrayRankTransform().new Solution();
        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        //[5,3,4,2,8,6,7,1,3]
        int[] out = solution.arrayRankTransform(arr);
        System.out.println(Arrays.stream(out).toArray());
    }

    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            int[] clone = arr.clone();
            Arrays.sort(clone);
            Map<Integer, Integer> map = new HashMap<>();
            int n = arr.length;
            int index = 0;
            for (int i : clone) {
                if (!map.containsKey(i)){
                    map.put(i,++index);
                }
            }
            int[] ans = new int[n];
            for(int i =0;i< n;i++){
                ans[i] = map.get(arr[i]);
            }
            return ans;
        }
    }


}
