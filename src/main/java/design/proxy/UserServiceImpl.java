package design.proxy;

import java.util.Collections;
import java.util.List;

/**
 * @author Ayuan
 * @Description: 用户查询实现类
 * @date 2023/4/27 09:46
 */
public class UserServiceImpl {
    // 查询功能
    List<String> findUserList() {
        return Collections.singletonList("小A");
    }
}
