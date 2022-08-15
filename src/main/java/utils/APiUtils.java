//package utils;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.util.StringUtils;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * api工具类
// * @author apple
// */
//public class APiUtils {
//     static final String KEY = "b6cea463e16bfbcecbe43e3f128f2eb7";
//    static final String BASE_PATH = "https://restapi.amap.com/v5/place/text";
//
//
//    public static JSONArray searchMap(String address,Integer type,String region){
//        try {
//            Map<String,Object> parameters = new HashMap<>(16);
//            String url = BASE_PATH + "?key=" + KEY + "&keywords="+ address + "&types="+ type + "&region=" + region + "&city_limit=true" ;
//            System.out.println("请求参数：" + url);
//            String jsonResult = HttpUtils.sendGet(url);
//            if (!StringUtils.isEmpty(jsonResult)) {
//                JSONObject resultJson = JSON.parseObject(jsonResult);
//                return resultJson.getJSONArray("pois");
//            }
//        } catch (Exception e) {
//            //异常返回空数组
//            return new JSONArray();
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        JSONArray objects = searchMap("欧洲街",150904,"上海市");
//        System.out.println(JSON.toJSONString(objects));
//    }
//
//}
