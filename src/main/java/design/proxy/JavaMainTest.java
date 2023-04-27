package design.proxy;

import java.util.List;

/**
 * @author Ayuan
 * @Description: Cglib测试
 * @date 2023/4/27 09:48
 */
public class JavaMainTest {
    public static void main(String[] args) {

        // 目标对象
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(userService.getClass());

        // 代理对象
        UserServiceImpl proxy = (UserServiceImpl) new UserLogProxy().getLogProxy(userService);
        System.out.println(proxy.getClass());

        List<String> list = proxy.findUserList();
        System.out.println("用户信息：" + list);

        while (true) {
        }
    }
}
