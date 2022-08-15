package leetcode.editor.cn;

import java.util.*;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器
 * @date 2022/8/9 13:31
 */
public class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    int idx = -1;
    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, ++idx);
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int valIdx = map.get(val);
        int swapVal = list.get(idx);
        map.put(swapVal, valIdx);
        map.put(val, idx);
        // 交换数组
        int t = list.get(idx);
        list.set(idx, val);
        list.set(valIdx, swapVal);
        // 删除数组最后一个元素
        list.remove(idx--);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        obj.insert(1);
        obj.remove(2);
        obj.insert(2);
        obj.getRandom();
        obj.remove(1);
        obj.insert(2);
        obj.getRandom();
    }
}
