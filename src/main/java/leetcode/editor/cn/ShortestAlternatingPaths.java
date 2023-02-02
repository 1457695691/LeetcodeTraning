package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ayuan
 * @Description: 1129. 颜色交替的最短路径
 * @date 2023/2/2 09:35
 */
public class ShortestAlternatingPaths {

    /**
     * BFS
     */
    class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            List<Integer>[] redList = new List[n];
            List<Integer>[] blueList = new List[n];
            for (int i = 0; i < n; ++i) {
                redList[i] = new ArrayList<>();
                blueList[i] = new ArrayList<>();
            }
            for (int[] e : redEdges) {
                redList[e[0]].add(e[1]);
            }
            for (int[] e : blueEdges) {
                blueList[e[0]].add(e[1]);
            }
            int[] redAns = new int[n];
            int[] blueAns = new int[n];
            for (int i = 1; i < n; i++) {
                redAns[i] = Integer.MAX_VALUE;
                blueAns[i] = Integer.MAX_VALUE;
            }
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{0, 0});
            queue.add(new int[]{0, 1});
            int level = 0;
            while (!queue.isEmpty()) {
                level++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] curArr = queue.poll();
                    int cur = curArr[0];
                    if (curArr[1] == 0) {
                        for (int next : redList[cur]) {
                            if (level < redAns[next]) {
                                redAns[next] = level;
                                queue.offer(new int[]{next, 1});
                            }
                        }
                    } else {
                        for (int next : blueList[cur]) {
                            if (level < blueAns[next]) {
                                blueAns[next] = level;
                                queue.offer(new int[]{next, 0});
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < redAns.length; i++) {
                if (blueAns[i] < redAns[i]) {
                    redAns[i] = blueAns[i];
                } else if (redAns[i] == Integer.MAX_VALUE)// 如果都为 [MAX] 证明无法走到
                {
                    redAns[i] = -1;
                }
            }
            return redAns;
        }
    }
}
