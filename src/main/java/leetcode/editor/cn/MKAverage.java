package leetcode.editor.cn;

import java.util.*;

/**
 * @author Ayuan
 * @Description: 1825. 求出 MK 平均值
 * @date 2023/1/18 09:32
 */
class MKAverage {

    // 维护元素的大小顺序
    TreeMap<Integer, Integer> treeMap;
    // 初始化m个长度的队列维护进入顺序
    Queue<Integer> queue;
    // 维护前m个元素和
    int sum;
    int m, k;

    public MKAverage(int m, int k) {
        treeMap = new TreeMap<>();
        queue = new ArrayDeque<>();
        this.m = m;
        this.k = k;
        sum = 0;
    }

    public void addElement(int num) {
        if (queue.size() == m) {
            //队列保持m个
            int peek = queue.poll();
            //如果只有一个元素就直接remove掉，多个就把次数-1
            if (1 == treeMap.get(peek)) {
                treeMap.remove(peek);
            } else {
                treeMap.put(peek, treeMap.get(peek) - 1);
            }
            //减去m个元素的前一个值
            sum -= peek;
        }
        // 维护num进treemap和queue
        queue.add(num);
        treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        // 加上num构成前m个元素的和
        sum += num;
    }

    public int calculateMKAverage() {
        // 元素个数不足返回-1
        if (queue.size() < m) return -1;
        // sum(m) - 正向sum(k) - 反向sum(k) / (m - 2k)
        return (sum - kSum(treeMap.entrySet().iterator()) - kSum(treeMap.descendingMap().entrySet().iterator())) / (m - 2 * k);
    }

    // 传入迭代器，计算迭代器前k个元素之和
    public int kSum(Iterator<Map.Entry<Integer, Integer>> it) {
        int cnt = k, kSum = 0;
        while (cnt > 0) {
            Map.Entry<Integer, Integer> entry = it.next();
            int v = Math.min(entry.getValue(), cnt);
            cnt -= v;
            //num * 出现次数
            kSum += entry.getKey() * v;
        }
        return kSum;
    }

    public static void main(String[] args) {
        MKAverage obj = new MKAverage(3, 1);
        obj.addElement(3);        // 当前元素为 [3]
        obj.addElement(1);        // 当前元素为 [3,1]
        obj.calculateMKAverage(); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
        obj.addElement(10);       // 当前元素为 [3,1,10]
        int i = obj.calculateMKAverage();// 最后 3 个元素为 [3,1,10]
        // 删除最小以及最大的 1 个元素后，容器为 [3]
        // [3] 的平均值等于 3/1 = 3 ，故返回 3
        obj.addElement(5);        // 当前元素为 [3,1,10,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
        int i1 = obj.calculateMKAverage();// 最后 3 个元素为 [5,5,5]

    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */