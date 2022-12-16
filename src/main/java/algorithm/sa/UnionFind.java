package algorithm.sa;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 并查集算法
 * @date 2022/12/13 16:01
 */
public class UnionFind {
    /**
     * 并查集是一种树形的数据结构，顾名思义，它用于处理一些不交集的合并及查询问题。 它支持两种操作：
     * 查找（Find）：确定某个元素处于哪个子集，单次操作时间复杂度 O(α(n))
     * 合并（Union）：将两个子集合并成一个集合，单次操作时间复杂度 O(α(n))
     * 其中 α 为阿克曼函数的反函数，其增长极其缓慢，也就是说其单次操作的平均运行时间可以认为是一个很小的常数。
     */

    /**
     * n:表示节点数
     * p:存储每个点的父节点，初始时每个点的父节点都是自己
     * size:只有当节点是祖宗节点时才有意义，表示祖宗节点所在集合中，点的数量
     * find(x):函数用于查找 xxx 所在集合的祖宗节点
     * union(a,b):函数用于合并 a 和 b 所在的集合
     */

    private int[] size;
    private int[] p;

    public UnionFind(int n) {
        p = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (p[x] != x) {
            // 路径压缩
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) {
            return;
        }
        p[pa] = pb;
        size[pb] += size[pa];
    }
}
