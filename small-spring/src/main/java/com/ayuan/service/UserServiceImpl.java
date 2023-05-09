package com.ayuan.service;

import com.ayuan.spring.Component;
import com.ayuan.spring.Scope;

/**
 * @author Ayuan
 * @Description: 测试service
 * @date 2023/5/8 15:01
 */
@Component("userServiceImpl")
//@Scope("prototype")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Override
    public String getName() {
        return "name";
    }
}
