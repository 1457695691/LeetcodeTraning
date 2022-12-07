package utils;

import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author Ayuan
 */
public class Utils {

    public static void main(String[] args) {
        String a ="1\t中国医学科学院北京协和医院\t80\t16.436\t96.436\n" +
                "2\t四川大学华西医院\t69.658\t20\t89.658\n" +
                "3\t中国人民解放军总医院\t59.74\t14.123\t73.863\n" +
                "4\t上海交通大学医学院附属瑞金医院\t36.598\t13.002\t49.6\n" +
                "5\t复旦大学附属中山医院\t34.382\t13.623\t48.005\n" +
                "6\t华中科技大学同济医学院附属同济医院\t22.995\t15.191\t38.186\n" +
                "7\t华中科技大学同济医学院附属协和医院\t23.011\t14.688\t37.699\n" +
                "8\t复旦大学附属华山医院\t23.919\t10.73\t34.649\n" +
                "9\t中山大学附属第一医院\t22.104\t12.226\t34.33\n" +
                "10\t浙江大学医学院附属第一医院\t17.823\t15.409\t33.232\n" +
                "11\t浙江大学医学院附属第二医院\t17.155\t13.909\t31.064\n" +
                "12\t北京大学第一医院\t20.161\t10.885\t31.046\n" +
                "13\t空军军医大学西京医院\t22.471\t8.061\t30.532\n" +
                "14\t北京大学第三医院\t19.638\t10.738\t30.376\n" +
                "15\t中南大学湘雅医院\t15.478\t14.729\t30.207\n" +
                "16\t中国医科大学附属第一医院\t16.936\t11.572\t28.508\n" +
                "17\t上海交通大学医学院附属仁济医院\t14.68\t13.525\t28.205\n" +
                "18\t南方医科大学南方医院\t14.953\t12.666\t27.619\n" +
                "19\t郑州大学第一附属医院\t12.262\t14.64\t26.902\n" +
                "20\t中南大学湘雅二医院\t11.081\t13.593\t24.674\n" +
                "21\t北京大学人民医院\t14.039\t10.26\t24.299\n" +
                "22\t江苏省人民医院（南京医科大学第一附属医院）\t10.032\t11.951\t21.983\n" +
                "23\t上海交通大学医学院附属第九人民医院\t9.527\t12.074\t21.601\n" +
                "24\t山东大学齐鲁医院\t10.515\t10.386\t20.901\n" +
                "25\t中国医学科学院肿瘤医院\t7.601\t12.193\t19.794\n" +
                "26\t首都医科大学附属北京天坛医院\t8.465\t10.672\t19.137\n" +
                "27\t中山大学肿瘤防治中心\t4.213\t14.066\t18.279\n" +
                "28\t复旦大学附属肿瘤医院\t7.005\t11.115\t18.12\n" +
                "29\t陆军军医大学第一附属医院\t10.564\t7.434\t17.998\n" +
                "30\t中国医学科学院阜外医院\t7.213\t10.141\t17.354\n" +
                "31\t广州医科大学附属第一医院\t8.154\t8.563\t16.717\n" +
                "32\t上海市第六人民医院\t6.213\t10.387\t16.6\n" +
                "33\t中国医科大学附属盛京医院\t5.04\t11.315\t16.355\n" +
                "34\t广东省人民医院\t7.277\t9.037\t16.314\n" +
                "35\t南京大学医学院附属鼓楼医院\t5.399\t10.889\t16.288\n" +
                "36\t首都医科大学附属北京同仁医院\t9.319\t6.668\t15.987\n" +
                "37\t首都医科大学宣武医院\t5.764\t8.634\t14.398\n" +
                "38\t四川省医学科学院·四川省人民医院\t7.766\t6.403\t14.169\n" +
                "39\t海军军医大学第一附属医院\t7.452\t6.658\t14.11\n" +
                "40\t武汉大学人民医院\t1.582\t12.236\t13.818\n" +
                "41\t首都医科大学附属北京儿童医院\t6.776\t7.001\t13.777\n" +
                "42\t上海市肺科医院\t6.174\t7.318\t13.492\n" +
                "43\t中日友好医院\t6.968\t6.411\t13.379\n" +
                "44\t四川大学华西口腔医院\t2.718\t10.566\t13.284\n" +
                "45\t中山大学附属第三医院\t3.417\t9.854\t13.271\n" +
                "46\t东南大学附属中大医院\t5.438\t7.674\t13.112\n" +
                "47\t复旦大学附属儿科医院\t6.601\t6.468\t13.069\n" +
                "48\t重庆医科大学附属第一医院\t1.536\t11.482\t13.018\n" +
                "49\t浙江大学医学院附属邵逸夫医院\t2.462\t10.334\t12.796\n" +
                "50\t首都医科大学附属北京安贞医院\t5.63\t7.07\t12.7\n" +
                "51\t复旦大学附属眼耳鼻喉科医院\t6.23\t6.231\t12.461\n" +
                "52\t山东第一医科大学附属省立医院（山东省立医院）\t3.518\t8.893\t12.411\n" +
                "53\t青岛大学附属医院\t1.959\t10.451\t12.41\n" +
                "54\t苏州大学附属第一医院\t2.425\t9.913\t12.338\n" +
                "55\t武汉大学中南医院\t0.802\t11.216\t12.018\n" +
                "56\t上海交通大学医学院附属新华医院\t2.922\t8.945\t11.867\n" +
                "57\t吉林大学第一医院\t0.496\t11.363\t11.859\n" +
                "58\t中国人民解放军东部战区总医院\t4.702\t7.142\t11.844\n" +
                "59\t天津医科大学总医院\t2.759\t9.055\t11.814\n" +
                "60\t北京医院\t4.716\t7.021\t11.737\n" +
                "61\t重庆医科大学附属儿童医院\t5.242\t6.305\t11.547\n" +
                "62\t北京大学肿瘤医院\t2.881\t8.652\t11.533\n" +
                "63\t西安交通大学第一附属医院\t0.79\t10.414\t11.204\n" +
                "64\t中山大学孙逸仙纪念医院\t2.553\t8.455\t11.008\n" +
                "65\t中山大学中山眼科中心\t3.301\t7.676\t10.977\n" +
                "66\t浙江大学医学院附属儿童医院\t4.077\t6.723\t10.8\n" +
                "67\t哈尔滨医科大学附属第二医院\t3.728\t7.07\t10.798\n" +
                "68\t首都医科大学附属北京朝阳医院\t2.914\t7.695\t10.609\n" +
                "69\t广州市妇女儿童医疗中心\t3.301\t7.209\t10.51\n" +
                "70\t四川大学华西第二医院\t2.136\t8.24\t10.376\n" +
                "71\t上海交通大学医学院附属上海儿童医学中心\t4.077\t5.708\t9.785\n" +
                "72\t首都医科大学附属北京友谊医院\t1.287\t8.402\t9.689\n" +
                "73\t中南大学湘雅三医院\t1.198\t8.472\t9.67\n" +
                "74\t天津医科大学肿瘤医院\t1.553\t8.095\t9.648\n" +
                "75\t安徽医科大学第一附属医院\t0.736\t8.893\t9.629\n" +
                "76\t北京积水潭医院\t5.436\t4.186\t9.622\n" +
                "77\t北京大学口腔医院\t3.301\t6.176\t9.477\n" +
                "78\t哈尔滨医科大学附属第一医院\t2.456\t6.888\t9.344\n" +
                "79\t上海市第一人民医院\t0.984\t8.111\t9.095\n" +
                "80\t上海市胸科医院（暨上海交通大学附属胸科医院）\t2.343\t6.741\t9.084\n" +
                "81\t中国医学科学院血液病医院（血液学研究所）\t3.301\t5.525\t8.826\n" +
                "82\t南昌大学第一附属医院\t0.942\t7.816\t8.758\n" +
                "83\t河南省人民医院\t0.817\t7.912\t8.729\n" +
                "84\t福建医科大学附属第一医院\t2.407\t6.05\t8.457\n" +
                "85\t复旦大学附属妇产科医院\t2.757\t5.581\t8.338\n" +
                "86\t陆军军医大学第二附属医院\t1.588\t6.693\t8.281\n" +
                "87\t南方医科大学珠江医院\t0.311\t7.766\t8.077\n" +
                "88\t福建医科大学附属协和医院\t0.953\t7.052\t8.005\n" +
                "89\t中国医学科学院整形外科医院\t2.718\t5.202\t7.92\n" +
                "90\t上海市精神卫生中心\t2.718\t5.18\t7.898\n" +
                "91\t浙江大学医学院附属妇产科医院\t2.136\t5.629\t7.765\n" +
                "92\t北京大学第六医院\t3.301\t4.275\t7.576\n" +
                "93\t上海市（复旦大学附属）公共卫生临床中心\t2.077\t5.376\t7.453\n" +
                "94\t海军军医大学第二附属医院\t1.67\t5.779\t7.449\n" +
                "95\t中国科学技术大学附属第一医院（安徽省立医院）\t1.064\t6.332\t7.396\n" +
                "96\t武汉大学口腔医院\t1.553\t5.804\t7.357\n" +
                "97\t西安交通大学第二附属医院\t0.26\t6.998\t7.258\n" +
                "98\t空军军医大学唐都医院\t2.444\t4.745\t7.189\n" +
                "99\t深圳市人民医院\t0.388\t6.649\t7.037\n" +
                "100\t首都医科大学附属北京胸科医院\t3.301\t3.701\t7.002";

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
