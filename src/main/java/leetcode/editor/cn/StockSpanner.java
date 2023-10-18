package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ayuan
 * @Description: 901. 股票价格跨度
 * @date 2023/10/7 09:48
 */
public class StockSpanner {
    Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int cnt = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            cnt += stack.pop()[1];
        }
        stack.push(new int[]{price, cnt});
        return cnt;
    }


    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}



