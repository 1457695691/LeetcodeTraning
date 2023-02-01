package leetcode.editor.cn;

import java.util.*;

/**
 * @author Ayuan
 * @Description: 1172. 餐盘栈
 * @date 2023/1/31 14:44
 */
public class DinnerPlates {
    int capacity;
    HashMap<Integer, Deque<Integer>> map;
    TreeSet<Integer> left; //当前已有的非满栈的编号
    TreeSet<Integer> right; //当前已加入的非空栈的编号

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        left = new TreeSet<>();
        right = new TreeSet<>();
    }

    public void push(int val) {
        //栈用完了，或者初始化没有栈的情况
        if (left.isEmpty()) {
            //新建一个编号+1的栈
            map.computeIfAbsent(map.size(), k -> new LinkedList<>()).offerLast(val);
            Integer index = map.size() - 1;
            right.add(index);
            if (map.get(index).size() < capacity) {
                left.add(index);
            }
        }
        //找个最小编号的栈扔进去
        else {
            Integer first = left.first();
            map.get(first).offerLast(val);
            right.add(first);
            if (map.get(first).size() == capacity) {
                left.remove(first);
            }
        }
    }

    public int pop() {
        if (right.isEmpty()) {
            return -1;
        }
        return this.popAtStack(right.last());
    }

    public int popAtStack(int index) {
        if (!map.containsKey(index) || map.get(index).isEmpty()) {
            return -1;
        }
        int res = map.get(index).pollLast();
        left.add(index);
        if (map.get(index).isEmpty()) {
            right.remove(index);
        }
        return res;
    }


    public static void main(String[] args) {
        DinnerPlates d = new DinnerPlates(1);
        d.push(1);
        d.push(2);
        d.push(3);
        int i = d.popAtStack(1);
        System.out.println(i);
        d.pop();
        d.pop();
    }
}




