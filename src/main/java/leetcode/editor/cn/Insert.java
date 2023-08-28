package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 57. 插入区间
 * @date 2023/8/28 10:04
 */
public class Insert {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int left = newInterval[0], right = newInterval[1];
            List<int[]> res = new ArrayList<>();
            for(int[] interval: intervals){
                //1.找到需要合并的区间
                if(newInterval == null || interval[1] < left){
                    res.add(interval);
                }
                //2.合并区间
                else if(interval[0] > right){
                    res.add(newInterval);
                    res.add(interval);
                    newInterval = null;
                }
                else{
                    newInterval[0] = Math.min(interval[0], newInterval[0]);
                    newInterval[1] = Math.max(interval[1], newInterval[1]);
                }
            }
            //3.处理合并区间之后的区间
            if(newInterval != null){
                res.add(newInterval);
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
