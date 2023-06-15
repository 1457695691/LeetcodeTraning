package test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2022/7/15 15:21
 */
public class BooleanTest {
    volatile static int i = 0;

    public static void main(String[] args) {
//        JsonResponse jsonResponse = new JsonResponse();
//        jsonResponse.setSuccess(false);
//        jsonResponse.setErrorCode("xxxxx");
//        jsonResponse.setErrorMsg("yyyy");
//
//
//        JSONObject jsonObject = (JSONObject) JSON.toJSON(jsonResponse);
//        System.out.println(jsonObject);
//
//        System.out.println();
//        String st = JSON.toJSONString(jsonResponse);
//        System.out.println(st);
//        JSONObject s = JSONObject.parseObject(st);
//        System.out.println(s);
//
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行了任务");
                if (i == 0) {

                    lock.readLock().lock();
                    i = i + 1;
                    lock.readLock().unlock();
                }

            }
        });

        thread.start();
    }
}
