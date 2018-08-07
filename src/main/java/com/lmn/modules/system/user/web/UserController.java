package com.lmn.modules.system.user.web;


import com.lmn.modules.system.user.dto.UserDTO;
import com.lmn.modules.system.user.service.impl.UserServiceImpl;
import com.lmn.utils.ExportExcel;
import com.lmn.utils.ImportExcel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/30.
 */
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/download")
    public void queryList(HttpServletRequest request, HttpServletResponse response){
        try {
            new ExportExcel("aa", UserDTO.class).setDataList(userService.queryList()).write(response,"aa.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(MultipartFile file){
        String name=file.getName();
        file.getOriginalFilename();
//        file.transferTo();
        ImportExcel ei = null;
        try {
            ei = new ImportExcel(file, 1, 0);
            List<UserDTO> list = ei.getDataList(UserDTO.class);

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        Map map =new HashMap();
        map.put("statusCode","000000");
        map.put("message","调用成功");
        map.put("data","-1");
        return map;

    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
