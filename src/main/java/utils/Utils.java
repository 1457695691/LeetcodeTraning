package utils;

import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author Ayuan
 */
public class Utils {

    public static void main(String[] args) {
        String a ="";

//        String b = "";

        String[] split = a.split("\n");
//        String[] split2 = b.split("\n");

        List<String> collect = Arrays.stream(split).collect(Collectors.toList());
//        List<String> collect2 = Arrays.stream(split2).collect(Collectors.toList());
        System.out.println("size ：" + collect.size());

//        collect.forEach(
//                it -> {
//                    System.out.println("('" + uuid() + "',10183,'洗牙保健兑换券'," + it + ",now(),now(),0,'2021-06-15 21:30:28','2022-06-15 21:30:28'),");
//                }
//        );

//        Set<String> set = new HashSet<>();
//        String[] p = b.split("\n");
//        Arrays.stream(p).forEach(
//                it -> {
//                    boolean add = set.add(it);
//                    if (!add) {
//                        System.out.println("重复：" + it);
//                    }
//                }
//        );
//        collect.forEach(
//                it->{
//                    boolean add = set.add(it);
//                    if (add){
//                        System.out.println("非重复"+it);
//                    }
//                }
//        );

        sql(collect);
//        Arrays.stream(split).forEach(
//                it->{
//                    String[] user = it.split("\t");
//                    System.out.println(
//                            "('"+user[0]+"', '"+user[1]+"', 0, now(), now(), 0, 0,'京东9.9拉新活动'),"
//                    );
//                }
//        );

//        List<String> collect = Arrays.stream(split).map(
//                it -> {
//                    return it;
//                }
//        ).collect(Collectors.toList());
//        sql(collect);
//        json2(collect);
//        String b = "虹桥商务区2路";
//        String[] split1 = b.split(";");
//        System.out.println(split1.length);
    }

    public static void sql(List<String> collect) {
        System.out.print("(");
        collect.stream().forEach(
                it -> {
                    System.out.print(it+ ",");
                }
        );
        System.out.print(")");

//        collect2.forEach(it -> {
//                    if (!collect.contains(it)) {
//                        System.out.println(it);
//                    }
//                }
//        );

//        System.out.print("INSERT INTO item_store(ID,ITEM_ID,STORE_ID,ITEM_SPU_ID,ADD_PRICE,MARK_PRICE,SOLD_PRICE,SERVER_PRICE,DISCOUNT,GMT_CREATE,GMT_MODIFIED)VALUES(");
//        collect.forEach(
//                it -> {
//                    System.out.print("("+ it + "137," + it + ",36800.0,42800.00,0,0.00,223,36800.00),");

                    //前牙 0
//                    System.out.print("(null,137," + it + ",36800.0,42800.00,0,0.00,223,36800.00),");
                    //前牙 300
//                    System.out.print("(null,133," + it + ",1880.00,1999.00,0,0.00,224,1100.00),");
                    //前牙 399
//                    System.out.print("(null,133," + it + ",1679.00,1999.00,0,0.00,224,1199.00),");
                    //后牙 0
//                    System.out.print("(null,134," + it + ",1480.00,1899.00,0,0.00,224,800.00),");
                    //后牙 300
//                     System.out.print("(null,134," + it + ",1780.00,1899.00,0,0.00,224,1100.00),");
                    //后牙 399
//                    System.out.print("(null,134," + it + ",1579.00,1899.00,0,0.00,224,1199.00),");
//                }
//        );

    }

    public static void json1(List<Integer> collect) {
        System.out.println("[");
        collect.stream().forEach(
                it -> {
                    System.out.println("{\"dentalStoreId\":" + it + "},");
                }
        );
        System.out.println("]");
    }

    public static void json2(List<String> collect) {
        System.out.println("[");
        collect.stream().forEach(
                it -> {
                    System.out.println("\"" + it + "\"" + ",");
                }
        );
        System.out.println("]");
    }

    public static void price(List<String> collect) {
        collect.stream().forEach(
                it -> {
                    String[] split = it.split("\t");
                    if (split.length == 11) {
                        String s = split[7];
                        double statementPrice = 0;
                        if (s.equals("1")) {
                            //固定结算
                            statementPrice = split[10].equals("1") ?
                                    Double.parseDouble(split[9])
                                    : Double.parseDouble(split[8]);
                        } else {
                            //比例结算
                            //ROUND_UP：向远离零的方向舍入（若舍入位为非零，则对舍入部分的前一位数字加1；若舍入位为零，则直接舍弃。即为向外取整模式。）
                            //ROUND_DOWN:向零的方向舍入，因为这里计算的是优惠后的金额，所以向0的方向舍入
                            statementPrice = split[10].equals("1") ?
                                    DoubleUtils.mul(Double.parseDouble(split[5]), Double.parseDouble(org.springframework.util.StringUtils.isEmpty(split[9]) ? "0.0" : split[9]), RoundingMode.DOWN)
                                    :
                                    DoubleUtils.mul(Double.parseDouble(split[5]), Double.parseDouble(org.springframework.util.StringUtils.isEmpty(split[8]) ? "0.0" : split[9]), RoundingMode.DOWN);
                        }
                        System.out.println(Integer.valueOf(split[0]) + "," + statementPrice);
                    }
                }
        );
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void update(List<String> collect) {
        collect.forEach(it -> {
            String[] split = it.split(",");
            System.out.println("update order_statement_detail set statement_price=" + split[1] + " where order_sub_id=" + split[0] + ";");
        });
    }
}
