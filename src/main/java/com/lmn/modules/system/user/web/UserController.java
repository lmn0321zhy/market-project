package com.lmn.modules.system.user.web;


import com.lmn.modules.system.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
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
    @RequestMapping("/demo")
    public void demo(){
        try {
            File csv = new File("F:/writers.csv"); // CSV数据文件

            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加
            // 添加新的数据行
            bw.write("\"李四\"" + "," + "\"1988\"" + "," + "\"1992\"");
            bw.newLine();
            bw.close();
        } catch (FileNotFoundException e) {
            // File对象的创建过程中的异常捕获
            e.printStackTrace();
        } catch (IOException e) {
            // BufferedWriter在关闭对象捕捉异常
            e.printStackTrace();
        }
    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
