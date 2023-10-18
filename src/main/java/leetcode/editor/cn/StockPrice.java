package leetcode.editor.cn;

import java.util.HashMap;

/**
 * @author Ayuan
 * @Description: 2034. 股票价格波动
 * @date 2023/10/8 10:56
 */
public class StockPrice {

    HashMap<Integer, Integer> map = new HashMap<>();

    public StockPrice() {

    }

    public void update(int timestamp, int price) {

    }

    public int current() {

    }

    public int maximum() {

    }

    public int minimum() {

    }


    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10); // 时间戳为 [1] ，对应的股票价格为 [10] 。
        stockPrice.update(2, 5);  // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
        stockPrice.current();     // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
        stockPrice.maximum();     // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
        stockPrice.update(1, 3);  // 之前时间戳为 1 的价格错误，价格更新为 3 。
        // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
        stockPrice.maximum();     // 返回 5 ，更正后最高价格为 5 。
        stockPrice.update(4, 2);  // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
        stockPrice.minimum();     // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
    }

}
