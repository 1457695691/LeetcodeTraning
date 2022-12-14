package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ayuan
 * @Description: 1697. 检查边长度限制的路径是否存在
 * @date 2022/12/14 14:32
 */
public class DistanceLimitedPathsExist {
    class Solution {
        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            //1.edgeList 按边长度从小到大进行排序
            Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
            //2.queries 按 limit 从小到大进行排序
            Integer[] index = new Integer[queries.length];
            for (int i = 0; i < queries.length; i++) {
                index[i] = i;
            }
            Arrays.sort(index, Comparator.comparingInt(a -> queries[a][2]));
            //3.初始化返回值
            boolean[] res = new boolean[queries.length];
            //3.建立并差集
            UnionFind uf = new UnionFind(n);
            //4.遍历index数组
            int k = 0;
            for (int i : index) {
                //取出a，b两个点和limit
                int a = queries[i][0], b = queries[i][1], limit = queries[i][2];
                //遍历 edgeList 中的所有边，依次将长度小于 limit 的边加入到并查集中
                while (k < edgeList.length && edgeList[k][2] < limit) {
                    int u = edgeList[k][0], v = edgeList[k][1];
                    uf.father[uf.find(u)] = uf.find(v);
                    k++;
                }
                //判断两个点之间是否有联通
                res[i] = uf.find(a) == uf.find(b);
            }
            return res;
        }
    }

    class UnionFind {
        public int[] father;

        public UnionFind(int n) {
            father = new int[n];

            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public int find(int n) {
            return father[n] == n ? n : (father[n] = find(father[n]));
        }

        public void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa != pb) {
                father[pa] = father[pb];
            }
        }
    }
}
