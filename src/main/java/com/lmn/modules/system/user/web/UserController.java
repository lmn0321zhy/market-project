package com.lmn.modules.system.user.web;


import com.lmn.modules.system.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/queryList")
    public List queryList(){
        return userService.queryList();
    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
