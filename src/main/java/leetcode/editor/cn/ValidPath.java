package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1971. 寻找图中是否存在路径
 * @date 2022/12/19 09:36
 */
public class ValidPath {

    /**
     * 并查集判断联通性
     */
    class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            UnionFind uf = new UnionFind(n);
            for (int[] edge : edges) {
                uf.merge(edge[0], edge[1]);
            }
            return uf.find(source) == uf.find(destination);
        }
    }


    class UnionFind {//并查集模板
        public int[] father;

        public UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        //找祖宗
        public int find(int x) {
            if (father[x] != x) father[x] = find(father[x]);
            return father[x];
        }

        //合并
        public void merge(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                father[x] = father[y];
            }
        }
    }
}
