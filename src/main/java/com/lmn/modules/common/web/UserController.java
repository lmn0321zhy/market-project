package com.lmn.modules.common.web;

import com.lmn.modules.common.service.UserService;
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
    private UserService userService;
    @RequestMapping("/queryList")
    public List queryList(){
        return userService.queryList();
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
