package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2492. 两个城市间路径的最小分数
 * @date 2022/12/13 15:06
 */
public class MinScore {

    class Solution {
        public int minScore(int n, int[][] roads) {
            int min = Integer.MAX_VALUE;
            //01建立并查集
            UnionFind unionFind = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                unionFind.add(i);
            }
            for (int[] road : roads) {
                //注意减一
                int a = road[0] - 1, b = road[1] - 1;
                if (!unionFind.isConnected(a, b)) unionFind.merge(a, b);
            }
            //02找权值最小边
            for (int[] road : roads) {
                int k = road[0] - 1;
                if (unionFind.isConnected(0, k) && road[2] < min) min = road[2];
            }
            return min;
        }
    }

    class UnionFind {//并查集模板
        private int[] father;
        private int size;

        public UnionFind(int n) {
            father = new int[n];
            size = 0;
        }

        //添加
        public void add(int x) {
            father[x] = x;
            size++;
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
                size--;
            }
        }

        //是否同属
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        //集合数量
        public int getSize() {
            return size;
        }
    }
}
