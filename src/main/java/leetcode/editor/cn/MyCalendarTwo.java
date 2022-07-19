package leetcode.editor.cn;

import java.util.TreeMap;

/**
 * @author Ayuan
 * @Description: 731. 我的日程安排表 II
 * @date 2022/7/19 10:09
 */
public class MyCalendarTwo {
    /**
     * 1.线段树
     * 2.查分数组
     * 3.暴力搜索
     */

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public MyCalendarTwo() {
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        //记录活跃的日程数
        int sum = 0;
        for (int v : map.values()) {
            sum += v;
            if (sum >= 3) {
                //恢复现场
                map.put(start, map.getOrDefault(start, 0) - 1);
                map.put(end, map.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean book;
        MyCalendarTwo obj = new MyCalendarTwo();
        book = obj.book(10, 20);
        System.out.println(book);
        book = obj.book(50, 60);
        System.out.println(book);
        book = obj.book(10, 40);
        System.out.println(book);
        book = obj.book(5, 15);
        System.out.println(book);
        book = obj.book(5, 10);
        System.out.println(book);
        book = obj.book(25, 55);
        System.out.println(book);
    }

}
