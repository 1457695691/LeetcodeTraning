package exception;

import java.util.logging.Logger;

/**
 * @author ayuan
 */
public class LocalException {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("LocalException");
        try {
            User source = new User();
            Object object = source.queryUserInfoById(null);
            logger.info("测试结果" + object);
        }catch (Exception e){
            //不看异常了！
        }
    }



    static class User{
        Logger logger = Logger.getLogger("User");
        public Object queryUserInfoById(String userId){
            logger.info("根据用户Id获取用户信息" + userId);
            if (null == userId){
                throw new NullPointerException("根据用户Id获取用户信息，空指针异常");
            }
            return userId;
        }

    }
}
