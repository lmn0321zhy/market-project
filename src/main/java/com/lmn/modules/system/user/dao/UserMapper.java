package com.lmn.modules.system.user.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */
@Mapper
public interface UserMapper{
        List queryList();
}
