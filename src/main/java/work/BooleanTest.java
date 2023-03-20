package work;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import exception.JsonResponse;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2022/7/15 15:21
 */
public class BooleanTest {
    public static void main(String[] args) {
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSuccess(false);
        jsonResponse.setErrorCode("xxxxx");
        jsonResponse.setErrorMsg("yyyy");


        JSONObject jsonObject = (JSONObject) JSON.toJSON(jsonResponse);
        System.out.println(jsonObject);

        System.out.println();
        String st = JSON.toJSONString(jsonResponse);
        System.out.println(st);
        JSONObject s = JSONObject.parseObject(st);
        System.out.println(s);
    }
}
