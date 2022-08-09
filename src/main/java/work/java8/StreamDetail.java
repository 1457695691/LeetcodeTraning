package work.java8;


import cn.hutool.json.JSONUtil;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StreamDetail {

    private static Random random = new Random();
    private List<Order> orders;

    @Before
    public void data() {
        orders = Order.getData();

        orders.forEach(System.out::println);
        System.out.println("==========================================");
    }

    @Test
    public void filter() {
        System.out.println("//最近半年的金额大于40的订单");
        orders.stream()
                .filter(Objects::nonNull)
                .filter(order -> order.getPlacedAt().isAfter(LocalDateTime.now().minusMonths(6)))
                .filter(order -> order.getTotalPrice() > 40)
                .forEach(System.out::println);
    }

    @Test
    public void map() {
        //计算所有订单商品数量
        //通过两次遍历实现
        LongAdder longAdder = new LongAdder();
        orders.stream().forEach(order ->
                order.getOrderItemList().forEach(orderItem -> longAdder.add(orderItem.getProductQuantity())));
        System.out.println(longAdder);
        //使用两次mapToLong+sum方法实现
        long sum =
                orders.stream().mapToLong(order -> order.getOrderItemList().stream().mapToLong(OrderItem::getProductQuantity).sum()).sum();
        System.out.println(sum);
        //把IntStream通过转换Stream<Project>
        List<Product> collect =
                IntStream.rangeClosed(1, 10).mapToObj(i -> new Product((long) i, "product" + i, i * 100.0)).collect(toList());
        System.out.println(collect);
    }

    @Test
    public void sorted() {
        System.out.println("//大于50的订单,按照订单价格倒序前5");
        orders.stream()
                .filter(order -> order.getTotalPrice() > 50)
                .sorted(comparing(Order::getTotalPrice).reversed())
                .forEach(System.out::println);
    }

    @Test
    public void flatMap() {
        //不依赖订单上的总价格字段
        System.out.println(orders.stream()
                .mapToDouble(Order::getTotalPrice)
                .sum()
        );

        //如果不依赖订单上的总价格,可以直接展开订单商品进行价格统计

        System.out.println(
                orders.stream()
                        .flatMap(order -> order.getOrderItemList().stream())
                        .mapToDouble(orderItem -> orderItem.getProductPrice() * orderItem.getProductQuantity())
                        .sum()
        );

        //另一种方式flatMap+mapToDouble=flatMapToDouble

        System.out.println(
                orders.stream()
                        .flatMapToDouble(order ->
                                order.getOrderItemList()
                                        .stream()
                                        .mapToDouble(item ->
                                                item.getProductQuantity() * item.getProductPrice()))
                        .sum()
        );

    }

    @Test
    public void groupBy() {
        System.out.println("//按照用户名分组，统计下单数量");
        orders.stream().collect(groupingBy(Order::getCustomerName, counting()))
                .entrySet()
                .stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("//按照用户名分组,统计订单总金额");
        orders.stream().collect(groupingBy(Order::getCustomerName, summingDouble(Order::getTotalPrice)))
                .entrySet()
                .stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("//按照用户名分组,统计商品采购数量");
        orders.stream().collect(groupingBy(Order::getCustomerName, summingInt(orders ->
                orders.getOrderItemList().stream().mapToInt(OrderItem::getProductQuantity).sum())))
                .entrySet()
                .stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("//统计最受欢迎的商品，倒序后取第一个");
        orders.stream()
                .flatMap(order -> order.getOrderItemList().stream())
                .collect(groupingBy(OrderItem::getProductName, summingInt(OrderItem::getProductQuantity)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("//统计最受欢迎的商品的另一种方式,直接利用maxBy");
        orders.stream()
                .flatMap(order -> order.getOrderItemList().stream())
                .collect(groupingBy(OrderItem::getProductName, summingInt(OrderItem::getProductQuantity)))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);

        System.out.println("//按照用户名分组，选用户下的总金额最大的订单");

        System.out.println("//根据下单年月分组统计订单ID列表");

        System.out.println("//根据下单年月+用户名两次分组，统计订单ID列表");
    }

}
