package com.lmn.modules.system.user.dto;

import com.lmn.utils.annotation.ExcelField;

/**
 * Created by Administrator on 2018/8/7.
 */
public class UserDTO {
    @ExcelField(title = "人ID",sort = 0)
    private String id;
    @ExcelField(title = "名称",sort = 1)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
