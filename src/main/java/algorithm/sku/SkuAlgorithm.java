package algorithm.sku;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author Ayuan
 * @Description: SKU选择器规格算法
 * @date 2022/11/17 16:44
 */
@Slf4j
public class SkuAlgorithm {


    /**
     * 构建可选的所有路径
     */
    public static Pair<Map<String, Set<Integer>>, Map<Integer, Set<Integer>>> skuCollection(List<String> initData) {
        //1.构建用户返回数据
        Map<String, Set<Integer>> result = Maps.newHashMap();
        //2.遍历所有库存
        for (String subKey : initData) {
            //2.1 根据；拆分key的组合
            String[] skuKeyAttrs = subKey.split(";");
            List<Integer> valuesIdList = Arrays.stream(skuKeyAttrs).map(p -> Integer.valueOf(p.split(":")[1])).sorted().collect(Collectors.toList());
            //2.2 获取所有的组合,相当于求幂集
            List<List<Integer>> subsets = subsets(valuesIdList.stream().mapToInt(Integer::intValue).toArray());
            //2.3 k:values的所有可能 v:set<proVal>
            subsets.forEach(it -> {
                //2.4.1先排序
                List<Integer> collect = it.stream().sorted().collect(Collectors.toList());
                //2.4.2 拼接所有可能作为key
                String key = StringUtils.join(collect, "-");
                //2.4.3 取propValuesIds的组合和valuesIdList的差集作为values
                List<Integer> values = valuesIdList.stream().filter(item -> !collect.contains(item)).collect(Collectors.toList());
                if (result.containsKey(key)) {
                    //存在,set里添加这个propVal
                    Set<Integer> integerSet = result.get(key);
                    integerSet.addAll(values);
                    result.put(key, integerSet);
                } else {
                    //不存在,直接新建
                    Set<Integer> set = Sets.newHashSet(values);
                    result.put(key, set);
                }
            });
        }
        //3.构造所有同级可选关系
        Map<Integer, Set<Integer>> keySetMap = getIntegerSetMap(initData);
        //4.填入单个选择的同级关系到result中
        keySetMap.forEach((k, vSet) -> {
            vSet.forEach(v -> {
                if (result.containsKey(v.toString())) {
                    log.info("当前规格v:{}", v);
                    Set<Integer> integers = result.get(v.toString());
                    log.info("插入前v对应result数据:{}", integers.toString());
                    Set<Integer> collect = vSet.stream().filter(it -> !Objects.equals(it, v)).collect(Collectors.toSet());
                    log.info("要插入v的数据:{}", collect);
                    integers.addAll(collect);
                    log.info("插入后v对应result数据:{}", integers);
                    result.put(v.toString(), integers);
                }
            });
        });
        //5.填入多个选择的同级关系到result中
        result.forEach((k, vSet) -> {
            //只要选两个以上的关系(k:2-13;v:[1,3,42])
            if (k.contains("-")) {
                //分割组合的key，每个k从结果集中取values
                String[] split = StringUtils.split(k, "-");
                //创建一个存交集的set
                Set<Integer> intersection = result.get(split[0]);
                for (int i = 1; i < split.length; i++) {
                    //两两比较取交集
                    intersection = Sets.intersection(result.get(split[i]), intersection);
                }
                //存到结果集里
                vSet.addAll(intersection);
                result.put(k, vSet);
            }
        });
        return new Pair<>(result,keySetMap);
    }

    private static Map<Integer, Set<Integer>> getIntegerSetMap(List<String> initData) {
        //k: propId ; v:propValuesIdSet
        Map<Integer, Set<Integer>> keySetMap = Maps.newHashMap();
        Set<String> prop = Sets.newHashSet();
        //根据逗号分割去重，拿到[propId:propValuesId]形式的set
        initData.forEach(skuKeyAttrs -> prop.addAll(Arrays.asList(skuKeyAttrs.split(";"))));
        //组合keySetMap
        prop.forEach(p -> {
            Integer key = Integer.valueOf(p.split(":")[0]);
            int value = Integer.parseInt(p.split(":")[1]);
            if (keySetMap.containsKey(key)) {
                //存在,set里添加这个propVal
                Set<Integer> integerSet = keySetMap.get(key);
                integerSet.add(value);
                keySetMap.put(key, integerSet);
            } else {
                //不存在,直接新建
                Set<Integer> set = Sets.newHashSet(value);
                keySetMap.put(key, set);
            }
        });
        return keySetMap;
    }

    /**
     * 计算nums的全排列(去掉空集)
     */
    public static List<List<Integer>> subsets(int[] nums) {
        //子集的长度是2的nums.length次方，这里通过移位计算
        int length = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>(length);
        //遍历从0到length中间的所有数字，根据数字中1的位置来找子集
        for (int i = 0; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                //如果数字i的某一个位置是1，就把数组中对应的数字添加到集合
                if (((i >> j) & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            if (!CollectionUtils.isEmpty(list)) {
                res.add(list);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3, 4});
        System.out.println(subsets);
    }
}
