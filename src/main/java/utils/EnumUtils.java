package utils;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;

/**
 * 枚举工具类
 * @author Ayuan
 */
public class EnumUtils {

    /**
     * 枚举转List
     * @return enum collection
     */
    public static <E extends Enum<E>> List<Map<Object, String>> enum2List(final Class<E> enumT,
                                                                          String... methodNames) {
        ArrayList<Map<Object, String>> list = new ArrayList<>();
        Map<Object, String> enum2Map = enum2Map(enumT, methodNames);
        if(MapUtils.isNotEmpty(enum2Map)){
            for (Map.Entry<Object, String> entry : enum2Map.entrySet()) {
                HashMap<Object, String> map = new HashMap<>(16);
                map.put("key",entry.getKey().toString());
                map.put("value", entry.getValue());
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 枚举转map结合value作为map的key,description作为map的value
     */
    public static <E extends Enum<E>> Map<Object, String> enum2Map(final Class<E> enumT,
                                                                   String... methodNames) {
        Map<Object, String> unmap = new HashMap<>(16);
        if (!enumT.isEnum()) {
            return unmap;
        }
        E[] enums = enumT.getEnumConstants();
        if (enums == null || enums.length <= 0) {
            return unmap;
        }
        int count = methodNames.length;
        String valueMethod = "getCode";
        //默认接口value方法
        String desMethod = "getDesc";
        //默认接口description方法
        if (count >= 1 && !"".equals(methodNames[0])) {
            //扩展方法
            valueMethod = methodNames[0];
        }
        if (count == 2 && !"".equals(methodNames[1])) {
            desMethod = methodNames[1];
        }
        for (E obj : enums) {
            try {
                Object resultValue = getMethodValue(valueMethod, obj);
                //获取value值
                if ("".equals(resultValue)) {
                    continue;
                }
                Object resultDes = getMethodValue(desMethod, obj);
                //获取description描述值
                if ("".equals(resultDes)) {
                    //如果描述不存在获取属性值
                    resultDes = obj;
                }
                unmap.put(resultValue, resultDes + "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return unmap;
    }


    /**
     * 根据反射，通过方法名称获取方法值，忽略大小写的
     * @return return value
     */
    private static <T> Object getMethodValue(String methodName, T obj,
                                             Object... args) {
        Object result = "";
        // boolean isHas = false;
        try {
            Method[] methods = obj.getClass().getMethods();
            //获取方法数组，这里只要共有的方法
            if (methods.length <= 0) {
                return result;
            }
            Method method = null;
            for (Method value : methods) {
                if (value.getName().equalsIgnoreCase(methodName)) {
                    //忽略大小写取方法
                    method = value;
                    break;
                }
            }

            if (method == null) {
                return result;
            }
            result = method.invoke(obj, args);
            //方法执行
            if (result == null) {
                result = "";
            }
            return result;
            //返回结果
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 通过value值获取对应的描述信息
     * @return enum description
     */
    public static <E extends Enum<E>> Object getEnumDescriotionByValue(Object value,
                                                                       final Class<E> enumT, String... methodNames) {

        E[] enums = enumT.getEnumConstants();
        if (enums == null || enums.length <= 0) {
            return "";
        }
        int count = methodNames.length;
        String valueMethod = "getValue";
        //默认获取枚举value方法，与接口方法一致
        String desMethod = "getDescription";
        //默认获取枚举description方法
        if (count >= 1 && !"".equals(methodNames[0])) {
            valueMethod = methodNames[0];
        }
        if (count == 2 && !"".equals(methodNames[1])) {
            desMethod = methodNames[1];
        }
        for (E e : enums) {
            try {
                Object resultValue = getMethodValue(valueMethod, e);
                //获取枚举对象value
                if (resultValue.toString().equals(value + "")) {
                    //存在则返回对应描述
                    return getMethodValue(desMethod, e);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "";
    }

}

