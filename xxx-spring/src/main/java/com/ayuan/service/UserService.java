package com.ayuan.service;

import com.ayuan.spring.Component;
import com.ayuan.spring.Scope;

/**
 * @author Ayuan
 * @Description: 测试service
 * @date 2023/5/8 15:01
 */
@Component("userService")
//@Scope("prototype")
@Scope("singleton")
public class UserService {

    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println(userService);
    }
}
