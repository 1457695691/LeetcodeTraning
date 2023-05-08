package com.ayuan.service;

import com.ayuan.spring.Autowired;
import com.ayuan.spring.Component;

/**
 * @author Ayuan
 * @Description: 登录测试
 * @date 2023/5/8 17:59
 */
@Component()
public class LoginService {

    @Autowired
    private UserService userService;


    public void login() {
        System.out.println(userService.getName());
    }

}
