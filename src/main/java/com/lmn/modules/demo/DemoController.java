package com.lmn.modules.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/31.
 */
@RestController
public class DemoController {
    @RequestMapping("/getDemo")
    public String getDemo(){
        return "111111111111";
    }
}
